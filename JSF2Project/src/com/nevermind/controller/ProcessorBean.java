package com.nevermind.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class ProcessorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FormBean formBean;
	
	public String getMessage(){
		if(formBean.getUsername() == null || formBean.getUsername().isEmpty()){
			return "Please input your username";
		}
		return "Hello " + formBean.getUsername();
	}

}
