package com.nevermind.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nevermind.nevermind.gson.serializer.DoubleSerializer;
import com.nevermind.nevermind.gson.serializer.IntegerSerializer;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil(){
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Integer.class, new IntegerSerializer());
		builder.registerTypeAdapter(Double.class, new DoubleSerializer());
		gson = builder.create();
	}
	
	public String fromObjectToJSON(Object object){
		return gson.toJson(object);
	}
	
	public <T>T fromJSONToObject(String jsonString, Class<T> type){
		return gson.fromJson(jsonString, type);
	}
}
