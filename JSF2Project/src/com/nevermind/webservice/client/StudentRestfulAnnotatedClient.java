package com.nevermind.webservice.client;

import java.io.IOException;

import com.nevermind.entity.StudentsList;

public class StudentRestfulAnnotatedClient extends AbstractRestfulClient{

	public StudentRestfulAnnotatedClient() throws IOException{
		super("localhost", 8080);
	}
	
	public String getOneStudentInJSON() throws IOException{
		sendGetRequest("POST", "", "/JSF2Project/jersey/students", "text/html");
		return getResponse(StudentsList.class);
	}
	
	public String getOneStudentInXML() throws IOException{
		sendGetRequest("GET", "", "/JSF2Project/jersey/students", "text/html");
		return getResponse(StudentsList.class);
	}
	
	public static void main(String[] args) throws IOException {
		StudentRestfulAnnotatedClient studentRestfulAnnotatedClient = new StudentRestfulAnnotatedClient();
		String response = studentRestfulAnnotatedClient.getOneStudentInJSON();
		System.out.println("JSON: \n" + response);
		response = studentRestfulAnnotatedClient.getOneStudentInXML();
		System.out.println("XML: \n" + response);
	}

}
