package com.nevermind.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="student")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student {
	
	private Long _id;
	private String name;
	private List<Score> scores;
	
	@XmlAttribute
	public Long get_id() {
		return _id;
	}
	
	public void set_id(Long _id) {
		this._id = _id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public List<Score> getScores() {
		return scores;
	}
	
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public String toString(){
		return _id + " - " + name + ": " + scores.toString();
	}
}
