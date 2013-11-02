package com.nevermind.webservice.restful;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nevermind.entity.Student;
import com.nevermind.entity.StudentsList;
import com.nevermind.entity.finder.StudentFinder;

@Path("/student/name/{name: [a-zA-Z]+}")
public class StudentRestfulAnnotatedWithConstraints {

	@Inject
	private StudentFinder studentFinder;
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StudentsList getStudentsWith(@PathParam("name") String name){
		List<Student> students =  studentFinder.getStudentsThatStartWith(name);
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().addAll(students);
		return studentsList;
	}
}
