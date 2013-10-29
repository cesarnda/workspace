package com.nevermind.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class FormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void doAction(){
		System.out.println("In doAction");
	}
	
}
