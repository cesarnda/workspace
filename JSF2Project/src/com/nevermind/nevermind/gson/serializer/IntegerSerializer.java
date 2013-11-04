package com.nevermind.nevermind.gson.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class IntegerSerializer implements JsonDeserializer<Integer>,
		JsonSerializer<Integer> {

	@Override
	public JsonElement serialize(Integer src, Type typeOfSrc,
			JsonSerializationContext context) {
		if(src == null){
			return null;
		}
		return new JsonPrimitive(src.intValue());
	}

	@Override
	public Integer deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		int integerValue;
		try{
			integerValue = json.getAsInt();
		}catch(Exception ex){
			return null;
		}
		return integerValue;
	}

}
