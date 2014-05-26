package com.nevermindcorp.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nevermindcorp.algorithms.Printer;
import com.nevermindcorp.algorithms.Step;

public class MergeSort implements Sorting {

	private Printer printer;
	
	public MergeSort(){
		printer = new Printer();
	}
	
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> list, List<Step> steps) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <T extends Comparable<T>> List<T> executeMergeSort(List<T> list, List<Step> steps){
		return list;
	}
	
	/**
	 * This method sorts the elements in a list assuming that the elements in [start, ..., middle)
	 * are already sorted, as well as the elements in [middle, end].
	 * This merge function is in O(n)
	 * 
	 * @param list
	 * @param start
	 * @param middle
	 * @param end
	 * @param steps
	 */
	private <T extends Comparable<T>>  void merge(List<T> list, int start, int middle, int end, List<Step> steps){
		int mergeListSize = end - start;
		List<T> mergeList = new ArrayList<T>(mergeListSize);
		int firstHalfIndex = start;
		int secondHalfIndex = middle;
		steps.add(new Step(printer.print(list, start, end), "Merging sublist"));
		for(int mergeListIndex = 0; mergeListIndex < mergeListSize; mergeListIndex++){
			if(list.get(firstHalfIndex).compareTo(list.get(secondHalfIndex)) <= 0){
				mergeList.add(list.get(firstHalfIndex++));
			}else{
				mergeList.add(list.get(secondHalfIndex++));
			}
			steps.add(new Step(printer.print(mergeList), "Building Merge List"));
		}
		
		for(int index = start; index < end; index++){
			list.set(index, mergeList.get(index));
		}
		
		steps.add(new Step(printer.print(list), "List After merging sublist from " + start + " to " + end));

	}

}
