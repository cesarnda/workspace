package com.nevermind.entity.finder;

import com.google.gson.annotations.SerializedName;

public class JSONQuery {
	
	@SerializedName("$regex")
	private String regex;

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}
}
