package com.nevermind.webservice.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.nevermind.entity.StudentsList;

public class AbstractRestfulClient {

	private Integer port;
	private String host;
	
	public AbstractRestfulClient(String host, Integer port) throws UnknownHostException{
		this.port = port;
		this.host = host;
	}
	
	public <T>T sendGetRequest(String path, Class<T> type){
		URL url;
		try {
			url = new URL(host +":" + port + path);
			HttpURLConnection connection = HttpURLConnection.class.cast(url.openConnection());
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream response = connection.getInputStream();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(StudentsList.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<T> parsedResponse = unmarshaller.unmarshal(new StreamSource(response), type);
			return parsedResponse.getValue();
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
