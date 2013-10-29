package com.nevermind.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class StudentsList {

	private List<Student> students;
	
	@XmlElement(name="student")
	public List<Student> getStudents(){
		if(students == null){
			students = new ArrayList<Student>();
		}
		return students;
	}
	
}
