package com.nevermind.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil(){
		gson = new Gson();
	}
	
	public String fromObjectToJSON(Object object){
		return gson.toJson(object);
	}
	
	public <T>T fromJSONToObject(String jsonString, Class<T> type){
		return gson.fromJson(jsonString, type);
	}
}
