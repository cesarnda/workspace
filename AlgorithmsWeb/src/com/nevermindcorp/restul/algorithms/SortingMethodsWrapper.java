package com.nevermindcorp.restul.algorithms;

import java.util.Map;

public class SortingMethodsWrapper {
	
	private Map<String, String> sortingMethods;
	
	public SortingMethodsWrapper(Map<String, String> sortingMethods){
		this.sortingMethods = sortingMethods;
	}
	
	public Map<String, String> getSortingMethods(){
		return sortingMethods;
	}

}
