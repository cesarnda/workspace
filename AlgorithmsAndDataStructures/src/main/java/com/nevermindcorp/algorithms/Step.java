package com.nevermindcorp.algorithms;

public class Step {
	
	private String step;
	private String description;
	
	public Step(){	
	}
	
	public Step(String step, String description) {
		super();
		this.step = step;
		this.description = description;
	}

	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
