package com.nevermind.webservice.restful;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nevermind.entity.StudentsList;
import com.nevermind.entity.finder.StudentFinder;

@Path("/students")
public class StudentRestfulAnnotated {

	private StudentFinder studentFinder;

	public StudentRestfulAnnotated(){
		try {
			studentFinder = new StudentFinder();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Produces({MediaType.APPLICATION_XML})
	public StudentsList getRandomStudent(){
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().add(studentFinder.getRandomStudent());
		return studentsList;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public StudentsList getRandomStudentInJSONFormat(){
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().add(studentFinder.getRandomStudent());
		return studentsList;
	}

}
