package com.nevermind.webservice.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.nevermind.entity.Score;
import com.nevermind.entity.Student;
import com.nevermind.entity.finder.StudentFinder;

@Path("/state")
public class StudentServiceWithCookies {

	@Inject
	private StudentFinder studentFinder;
	private static Map<String, Student> sessionInformation = new HashMap<String, Student>();
	
	
	@GET
	@Path("/student/{id: \\d+}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getStudent(@PathParam("id")Long studentId){
		Student student = studentFinder.getUniqueStudent(studentId);
		Map<String, String> information = new HashMap<String, String>();
		information.put("id", student.get_id().toString());
		information.put("name", student.getName());
		
		String sessionId = System.currentTimeMillis() + "";
		sessionInformation.put(sessionId, student);
		NewCookie cookie = new NewCookie("studentSession", sessionId);
		NewCookie cookie_01 = new NewCookie("otherCookie", "otherCookieValue");
		NewCookie cookie_03 = new NewCookie("key", "value");
		Response response = Response.ok(information).cookie(cookie, cookie_01, cookie_03).build();
		
		return response;
	}
	
	@GET
	@Path("/student/information/")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Score> getScores(@CookieParam("studentSession") Cookie cookie){
		if(cookie == null){
			return new ArrayList<>();
		}
		Student student = sessionInformation.get(cookie.getValue());
		if(student == null){
			return new ArrayList<>();
		}
		return student.getScores();
	}
	
	
}
