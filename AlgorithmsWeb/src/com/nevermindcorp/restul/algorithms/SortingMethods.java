package com.nevermindcorp.restul.algorithms;

import java.util.List;

import com.nevermindcorp.algorithms.Step;
import com.nevermindcorp.algorithms.sorting.BubbleSort;
import com.nevermindcorp.algorithms.sorting.InsertionSort;
import com.nevermindcorp.algorithms.sorting.MergeSort;
import com.nevermindcorp.algorithms.sorting.QuickSort;
import com.nevermindcorp.algorithms.sorting.SelectionSort;
import com.nevermindcorp.algorithms.sorting.Sorting;

public enum SortingMethods {

	BUBBLE_SORT("Bubble Sort", new BubbleSort()),
	INSERTION_SORT("Insertion Sort", new InsertionSort()),
	MERGE_SORT("Merge Sort", new MergeSort()),
	QUICK_SORT("Quick Sort", new QuickSort()),
	SELECTION_SORT("Selection Sort", new SelectionSort());
	
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
