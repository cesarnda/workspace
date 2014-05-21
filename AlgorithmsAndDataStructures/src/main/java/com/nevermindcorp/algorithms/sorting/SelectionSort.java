package com.nevermindcorp.algorithms.sorting;

import java.util.List;

import com.nevermindcorp.algorithms.Printer;
import com.nevermindcorp.algorithms.Step;

public class SelectionSort implements Sorting{
	
	private transient Printer printer;
	
	
	public SelectionSort(){
		printer = new Printer();
	}
	
	private <T extends Comparable<T>>  void sortList(List<T> list, List<Step> steps){
		int size = list.size();
		int minimumIndex;
		steps.add(new Step(printer.print(list), "Initial order"));
		
		for(int i = 0; i < size - 1; i++){
			minimumIndex = i;
			for(int j = i + 1; j < size; j++){
				if(list.get(j).compareTo(list.get(minimumIndex)) < 0){
					minimumIndex = j; 
				}
			}
			// Swapping A[i] and A[min]
			T elementInI = list.get(i);
			T elementInMin = list.get(minimumIndex);
			String swappingDescription = printer.printSwapping(list, i, minimumIndex);
			list.set(i, elementInMin);
			list.set(minimumIndex, elementInI);
			steps.add(new Step(printer.print(list), swappingDescription));
		}
	}


	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> list, List<Step> steps) {
		sortList(list, steps);
		return list;
	}
	
	@Override
	public String toString(){
		return "Selection Sort";
	}

}
