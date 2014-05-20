package com.nevermindcorp.restul.algorithms;

import java.util.List;

import com.nevermindcorp.algorithms.Step;
import com.nevermindcorp.algorithms.sorting.BubbleSort;
import com.nevermindcorp.algorithms.sorting.SelectionSort;
import com.nevermindcorp.algorithms.sorting.Sorting;

public enum SortingMethods {
	
	SELECTION_SORT("Selection Sort", new SelectionSort()),
	BUBBLE_SORT("Bubble Sort", new BubbleSort());
	
	private String methodName;
	private Sorting sortingMethod;
	
	private SortingMethods(String methodName, Sorting sortingMethod){
		this.methodName = methodName;
		this.sortingMethod = sortingMethod;
	}
	
	public <T extends Comparable<T>>List<T> sort(List<T> list, List<Step> steps){
		return sortingMethod.sort(list, steps);
	}
	
	public String getKey(){
		return methodName.toUpperCase().replaceAll(" ", "_");
	}
	
	@Override
	public String toString(){
		return methodName;
	}

}
