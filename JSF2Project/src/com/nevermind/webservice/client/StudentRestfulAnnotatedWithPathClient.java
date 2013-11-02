package com.nevermind.webservice.client;

import java.io.IOException;
import java.util.Random;

import com.nevermind.entity.StudentsList;

public class StudentRestfulAnnotatedWithPathClient extends AbstractRestfulClient{

	public StudentRestfulAnnotatedWithPathClient() throws IOException{
		super("localhost", 8080);
	}
	
	public String getOneStudentInJSON(Long studentId) throws IOException{
		sendGetRequest("GET", "", "/JSF2Project/jersey/student/" + studentId, "text/html", "application/json");
		return getResponse(StudentsList.class);
	}
	
	public String getOneStudentInXML(Long studentId) throws IOException{
		sendGetRequest("GET", "", "/JSF2Project/jersey/student/" + studentId, "text/html", null);
		return getResponse(StudentsList.class);
	}
	
	public static void main(String[] args) throws IOException {
		Random random = new Random();
		Long studentId = Math.abs(random.nextLong() % 200);
		System.out.println("Student id: " + studentId);
		StudentRestfulAnnotatedWithPathClient studentRestfulAnnotatedWithPathClient = new StudentRestfulAnnotatedWithPathClient();
		String response = studentRestfulAnnotatedWithPathClient.getOneStudentInJSON(studentId);
		System.out.println("JSON: \n" + response);
		response = studentRestfulAnnotatedWithPathClient.getOneStudentInXML(studentId);
		System.out.println("XML: \n" + response);
	}

}
