package com.nevermind.webservice.restful;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nevermind.entity.Student;
import com.nevermind.entity.StudentsList;
import com.nevermind.entity.finder.StudentFinder;


@Path("/student/{id}")
public class StudentRestfulAnnotatedWithPath {

	private StudentFinder studentFinder;
	
	public StudentRestfulAnnotatedWithPath(){
		try {
			studentFinder = new StudentFinder();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StudentsList getStudent(@PathParam("id")Long studentId){
		Student student = studentFinder.getUniqueStudent(studentId);
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().add(student);
		return studentsList;
	}
	
	
}
