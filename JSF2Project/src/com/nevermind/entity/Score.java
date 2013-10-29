package com.nevermind.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Score {

	private String type;
	private Double score;
	
	@XmlElement
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
	
	public String toString(){
		return type + ": " + score;
	}
}
