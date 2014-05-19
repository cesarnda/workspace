package com.nevermindcorp.algorithms;

import java.util.List;

public class Printer {

	
	public <T>String print(List<T> list){
		if(list == null || list.isEmpty()){
			return "";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for(T t : list){
			stringBuilder.append(t.toString());
			stringBuilder.append(", ");
		}
		String elements = stringBuilder.toString();
		
		return elements.substring(0, elements.length() - 2);
	}
	
	public <T>String printSwapping(List<T> list, int i, int j){
		return "Swapping element " + list.get(i) + " in index " + i + " with element " + list.get(j) + " in index " + j;
	}
	
}
