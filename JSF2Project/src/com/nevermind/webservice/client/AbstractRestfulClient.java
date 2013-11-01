package com.nevermind.webservice.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.nevermind.entity.StudentsList;

public class AbstractRestfulClient {

	private Integer port;
	private String host;
	private InetAddress address;
	private Socket socket;
	
	public AbstractRestfulClient(String host, Integer port) throws IOException{
		this.port = port;
		this.host = host;
		address = InetAddress.getByName(host);
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
	
	public void sendGetRequest(String method, String request, String path, String contentType){
		try{
			socket = new Socket(address, port);
			Writer out = new OutputStreamWriter(socket.getOutputStream());
			out.write(method + " " + path + " HTTP/1.0\r\n");
			out.write("Content-Length: " + request.length() + "\r\n");
			out.write("Content-Type: " + contentType + "\r\n");
			out.write("\r\n");
			out.write(request);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public <T>String getResponse(Class<T> type) throws IOException{
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		
		StringBuilder response = new StringBuilder();
		
		while((line = bufferedReader.readLine()) != null){
			if(line.contains("{")  || line.contains("<")){
				response.append(line);
			}
		}
		socket.close();
		return response.toString();
	}
}
