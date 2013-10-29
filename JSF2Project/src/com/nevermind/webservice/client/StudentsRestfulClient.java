package com.nevermind.webservice.client;

import java.net.UnknownHostException;

import com.nevermind.entity.Student;
import com.nevermind.entity.StudentsList;

public class StudentsRestfulClient extends AbstractRestfulClient {

	public StudentsRestfulClient() throws UnknownHostException{
		super("http://localhost", 9010);
	}
	
	
	public Student getUniqueStudent(Long id){
		StudentsList response = sendGetRequest("/?id=" + id, StudentsList.class);
		if(response.getStudents().size() == 1){
			return response.getStudents().get(0);
		}

		return null;
	}
	
	
	public static void main(String ... args) throws UnknownHostException{
		StudentsRestfulClient studentsRestfulClient = new StudentsRestfulClient();
		Student student = studentsRestfulClient.getUniqueStudent(4L);
		
	}
	
}
