package com.nevermind.entity.finder;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nevermind.entity.Student;

public class StudentFinder extends AbstractFinder{

	public StudentFinder() throws UnknownHostException{
		super("school", "students");
	}
	
	public Student getUniqueStudent(Long id){
		Student student = new Student();
		student.set_id(id);
		return getUniqueElement(student, Student.class);
	}
	
	public List<Student> getStudentsThatStartWith(String startWith){
		Map<String, Object> startWithNameConstraint = new HashMap<String, Object>();
		JSONQuery jsonQuery = new JSONQuery();
		jsonQuery.setRegex("^" + startWith + ".*");
		startWithNameConstraint.put("name", jsonQuery);
		return getCollectionByQuery(startWithNameConstraint, Student.class);
	}
	
	public Student getRandomStudent(){
		return getRandomElement(Student.class);
	}
	
	public static void main(String ... args) throws UnknownHostException{
		StudentFinder studentFinder = new StudentFinder();
		List<Student> students = studentFinder.getStudentsThatStartWith("aimee");
		for (Student student : students) {
			System.out.println(student.get_id() + ": " + student.getName());
		}
	}
	
}
