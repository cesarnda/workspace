package com.nevermind.webservice.restful;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nevermind.entity.StudentsList;
import com.nevermind.entity.finder.StudentFinder;

@Path("/students")
public class StudentRestfulAnnotated {

	@Inject
	private StudentFinder studentFinder;

	public StudentRestfulAnnotated(){
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
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public StudentsList getRandomStudentAlsoInJSON(){
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().add(studentFinder.getRandomStudent());
		return studentsList;
	}

}
