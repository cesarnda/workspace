package com.nevermind.webservice.client;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import com.nevermind.entity.User;
import com.nevermind.entity.finder.UserFinder;

public class GoogleFinanceRestClient {	
	private static String AUTH_URL = "www.google.com";
	private static String FINANCE_URL = "www.google.com";
	
	public static void main(String ... args) throws IOException, URISyntaxException{
		GoogleFinanceRestClient googleFinanceRestClient = new GoogleFinanceRestClient();
		String token = googleFinanceRestClient.getAuthToken();
		String addPortfolioResponse = googleFinanceRestClient.addPortfolio(token, "My Restful Portfolio from Google");
		System.out.println("Add Portfolio Response: \n" + addPortfolioResponse);
		String path = googleFinanceRestClient.storeContentsInFile(addPortfolioResponse);
		Desktop.getDesktop().browse(new URI("file:///" + path));
		//String getPortfoliosResponse = googleFinanceRestClient.getPortfolios(token);
		//System.out.println("Get Portfolios Response: " + getPortfoliosResponse);
		
	}
	
	private String storeContentsInFile(String contents){
		File file = new File("result.html");
		try(FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.append(contents);
			System.out.println("File is stored in: " + file.getAbsolutePath());
			return file.getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPortfolios(String token) throws UnknownHostException{
		InetAddress address = InetAddress.getByName(FINANCE_URL);
		try(Socket socket = new Socket(address, 80)){
			sendRequest("GET", "", socket, "/finance/portfolio", "application/x-www-form-urlencoded", token);
			return getResponse(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public String addPortfolio(String token, String portfolioName) throws UnknownHostException{
		InetAddress address = InetAddress.getByName(FINANCE_URL);
		try(Socket socket = new Socket(address, 80)){
			String request = String.format(Charset.defaultCharset().decode(ByteBuffer.wrap(Files.readAllBytes(Paths.get("resources/atom_portfolio.xml")))).toString(), portfolioName);
				
			sendRequest("POST", request, socket, "/finance/portfolio", "application/atom+xml", token);
			
			System.out.println("Add request body:\n " + request);
					
			return getResponse(socket);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void sendRequest(String method, String request, Socket socket, String path, String contentType, String token) throws IOException{
		Writer out = new OutputStreamWriter(socket.getOutputStream());
		out.write(method + " " + path + " HTTP/1.0\r\n");
		out.write("Content-Length: " + request.length() + "\r\n");
		out.write("Content-Type: " + contentType + "\r\n");
		if(token != null && token.trim().length() > 0){
			out.write("Authorization: GoogleLogin auth=" + token + "\r\n");
		}
		out.write("\r\n");
		out.write(request);
		out.flush();
	}
	
	private String getResponse(Socket socket) throws IOException{
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		
		StringBuilder response = new StringBuilder();
		
		while((line = bufferedReader.readLine()) != null){
			response.append(line + '\n');
		}
		
		return response.toString();
	}
	
	public String getAuthToken(){
		User user = null;
		try {
			user = new UserFinder().getUniquerUser("cesarnda@gmail.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		StringBuilder query = new StringBuilder(encodeKeyValuePair("Email", user.getUsername()));
		query.append("&").append(encodeKeyValuePair("Passwd", user.getPassword()));
		query.append("&").append(encodeKeyValuePair("accountType", "GOOGLE"));
		query.append("&").append(encodeKeyValuePair("service", "finance"));
		query.append("&").append(encodeKeyValuePair("source", "restful-test"));
		
		try(SSLSocket socket = getSecureSocket()) {
			sendRequest("POST", query.toString(), socket, "/accounts/ClientLogin", "application/x-www-form-urlencoded", null);
			String response = getResponse(socket);
			System.out.println("Response for token: \n" + response);
			int indexOfAuthLine = response.indexOf("Auth=");
			String authToken = response.substring(indexOfAuthLine + 5, response.indexOf("\n", indexOfAuthLine));
			
			
			if(!"".equals(authToken)){
				System.out.println("Got AUTH Token = " + authToken);
			}
			
			return authToken;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private SSLSocket getSecureSocket(){
		int HTTPS_PORT = 443;
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		SSLSocketFactory sslSocketFactory = SSLSocketFactory.class.cast(SSLSocketFactory.getDefault());
		try {
			SSLSocket socket = SSLSocket.class.cast(sslSocketFactory.createSocket(AUTH_URL, HTTPS_PORT));
			String[] suites = socket.getSupportedCipherSuites();
			socket.setEnabledCipherSuites(suites);
			return socket;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String encodeKeyValuePair(String key, String value){
		try {
			return key + "=" + URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
