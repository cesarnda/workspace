package com.nevermind.webservice.client;

import java.io.IOException;

import com.nevermind.entity.Score;
import com.nevermind.entity.Student;
import com.nevermind.entity.StudentsList;

public class StudentsRestfulClient extends AbstractRestfulClient {

	public StudentsRestfulClient() throws IOException{
		super("http://localhost", 8080);
	}
	
	
	public Student getUniqueStudent(Long id){
		StudentsList response = sendGetRequest("/?id=" + id, StudentsList.class);
		if(response.getStudents().size() == 1){
			return response.getStudents().get(0);
		}

		return null;
	}
	
	
	public static void main(String ... args) throws IOException{
		StudentsRestfulClient studentsRestfulClient = new StudentsRestfulClient();
		Student student = studentsRestfulClient.getUniqueStudent(4L);
		System.out.println("Id: " + student.get_id());
		System.out.println("Name: " + student.getName());
		for(Score score : student.getScores()){
			System.out.println("\t" + score.getType() + ": " + score.getScore());
		}
	}
	
}
