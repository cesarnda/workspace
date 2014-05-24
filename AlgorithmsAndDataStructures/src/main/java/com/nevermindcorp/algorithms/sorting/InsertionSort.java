package com.nevermindcorp.algorithms.sorting;

import java.util.List;

import com.nevermindcorp.algorithms.Printer;
import com.nevermindcorp.algorithms.Step;

public class InsertionSort implements Sorting {

	Printer printer;
	
	public InsertionSort(){
		printer = new Printer();
	}
	
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> list, List<Step> steps) {
		executeInsertionSort(list, steps);
		return list;
	}
	
	
	private <T extends Comparable<T>> List<T> executeInsertionSort(List<T> list, List<Step> steps){
		int element;
		steps.add(new Step(printer.print(list), "Initial order"));
		for(int index = 1; index < list.size(); index++){
			element = index;
			while(element > 0){
				if(list.get(element - 1).compareTo(list.get(element)) > 0){
					swap(list, element - 1, element, steps);
				}
				element--;
			}
		}
		return list;
	}
	
	private <T>void swap(List<T> list, int i, int j, List<Step> steps){
		// Swapping A[i] and A[min]
		T elementInI = list.get(i);
		T elementInMin = list.get(j);
		String swappingDescription = printer.printSwapping(list, i, j);
		list.set(i, elementInMin);
		list.set(j, elementInI);
		steps.add(new Step(printer.print(list), swappingDescription));
	}
	
}
