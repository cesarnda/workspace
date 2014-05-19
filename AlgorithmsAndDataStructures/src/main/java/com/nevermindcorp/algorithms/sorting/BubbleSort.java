package com.nevermindcorp.algorithms.sorting;

import java.util.List;

import com.nevermindcorp.algorithms.Printer;
import com.nevermindcorp.algorithms.Step;

public class BubbleSort implements Sorting{

private Printer printer;
	
	
	public BubbleSort(){
		printer = new Printer();
	}
	
	private <T extends Comparable<T>>  void sortList(List<T> list, List<Step> steps){
		int size = list.size();
		steps.add(new Step(printer.print(list), "Initial order"));
		
		for(int i = 0; i < size - 1; i++){
			for(int j = 0; j < size - 1 - i; j++){
				if(list.get(j + 1).compareTo(list.get(i)) < 0){
					swap(list, j, j + 1, steps);
				}
			}
			
		}
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


	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> list, List<Step> steps) {
		sortList(list, steps);
		return list;
	}
	
}
