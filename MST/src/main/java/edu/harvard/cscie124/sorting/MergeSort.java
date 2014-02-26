package edu.harvard.cscie124.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorter{

	@Override
	public <T extends Comparable<? super T>> void sort(List<T> unsortedList) {
		List<T> sortedList = mergeSort(unsortedList);
		unsortedList.clear();
		unsortedList.addAll(sortedList);
	}
	
	
	public <T extends Comparable<? super T>>  List<T> mergeSort(List<T> unsortedElements){
		if(unsortedElements.size() <= 1){
			return unsortedElements;
		}
		int middlePoint = (int)Math.floor(unsortedElements.size() / 2);
		return merge(	mergeSort( cloneList(unsortedElements.subList( 0,  middlePoint)) ), 
						mergeSort( cloneList(unsortedElements.subList( middlePoint, unsortedElements.size())) )
					);
	}
	
	public <T extends Comparable<? super T>>  List<T> cloneList(List<T> list){
		List<T> clonedList = new ArrayList<T>();
		for(T element : list){
			clonedList.add(element);
		}
		
		return clonedList;
	}
	
	public <T extends Comparable<? super T>>  List<T> merge(List<T> sortedElements01, List<T> sortedElements02){		
		
		if(sortedElements01.isEmpty()){
			return sortedElements02;
		}
		
		if(sortedElements02.isEmpty()){
			return sortedElements01;
		}
		
		List<T> sortedElements = new ArrayList<T>();
		if(sortedElements01.get(0).compareTo(sortedElements02.get(0)) <= 0){
			sortedElements.add(sortedElements01.remove(0));
		}else{
			sortedElements.add(sortedElements02.remove(0));
		}
		
		sortedElements.addAll(merge(sortedElements01, sortedElements02));
		
		return sortedElements;
	}
}
