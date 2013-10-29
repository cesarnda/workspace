package com.nevermind.webservice.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class GetClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String urlString = "http://www.amazon.com/index.html";
		openConnectionClient(urlString);
	}
	
	public static void getConnectionWithSocket(String urlString) throws IOException{
		URL url = null;
		url = new URL(urlString);

		String host = url.getHost();
		String path = url.getPath();
		int port = url.getPort();

		if(port < 0){
			port = 80;
		}

		String request = "GET " + path + " HTTP/1.1\n";
		request += "host: " + host;
		request += "\n\n";
		Socket socket = null;

		socket = new Socket(host, port);

		PrintWriter writer = null;
		writer = new PrintWriter(socket.getOutputStream());

		writer.print(request);
		writer.flush();

		// Read and print the response

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String nextRecord = null;
		while((nextRecord = reader.readLine()) != null){
			System.out.println(nextRecord);
		}

		socket.close();
	}
	
	public static void openConnectionClient(String urlString) throws IOException{
		URL url = new URL(urlString);
		URLConnection socket = url.openConnection();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String nextRecord = null;
		
		while((nextRecord = reader.readLine()) != null){
			System.out.println(nextRecord);
		}
		
		reader.close();
	}

}
