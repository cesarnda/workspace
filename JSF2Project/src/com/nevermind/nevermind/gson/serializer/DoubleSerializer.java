package com.nevermind.nevermind.gson.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DoubleSerializer implements JsonDeserializer<Double>,
JsonSerializer<Double>  {

	@Override
	public JsonElement serialize(Double src, Type typeOfSrc,
			JsonSerializationContext context) {
		if(src == null){
			return null;
		}
		return new JsonPrimitive(src.doubleValue());
	}

	@Override
	public Double deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		double doubleValue;
		try{
			doubleValue = json.getAsDouble();
		}catch(Exception ex){
			return null;
		}
		return doubleValue;
	}
	
	

}
