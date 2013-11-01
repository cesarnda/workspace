package com.nevermind.entity.finder;

import java.net.UnknownHostException;

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
	
	public Student getRandomStudent(){
		return getRandomElement(Student.class);
	}
	
}
