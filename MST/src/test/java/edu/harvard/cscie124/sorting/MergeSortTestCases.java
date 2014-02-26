package edu.harvard.cscie124.sorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MergeSortTestCases {

	
	@Test
	public void merge_Test_With_Two_Sorted_List_With_Same_Length_With_Second_List_Going_First(){
		List<Integer> list01 = new ArrayList<Integer>();
		list01.add(10);
		list01.add(11);
		list01.add(12);
		list01.add(13);
		list01.add(14);
		list01.add(15);
		
		List<Integer> list02 = new ArrayList<Integer>();
		list02.add(3);
		list02.add(4);
		list02.add(5);
		list02.add(6);
		list02.add(7);
		list02.add(8);
		list02.add(9);
		
		List<Integer> expectedMergedList = new ArrayList<Integer>();
		expectedMergedList.add(3);
		expectedMergedList.add(4);
		expectedMergedList.add(5);
		expectedMergedList.add(6);
		expectedMergedList.add(7);
		expectedMergedList.add(8);
		expectedMergedList.add(9);
		expectedMergedList.add(10);
		expectedMergedList.add(11);
		expectedMergedList.add(12);
		expectedMergedList.add(13);
		expectedMergedList.add(14);
		expectedMergedList.add(15);
		
		MergeSort mergeSort = new MergeSort();
		
		List<Integer> mergedList = mergeSort.merge(list01, list02);
		assertEquals(expectedMergedList, mergedList);
	}
	
	@Test
	public void merge_Test_With_Two_Sorted_List_With_Same_Length(){
		List<Integer> list01 = new ArrayList<Integer>();
		list01.add(1);
		list01.add(2);
		
		List<Integer> list02 = new ArrayList<Integer>();
		list02.add(3);
		list02.add(4);
		
		List<Integer> expectedMergedList = new ArrayList<Integer>();
		expectedMergedList.add(1);
		expectedMergedList.add(2);
		expectedMergedList.add(3);
		expectedMergedList.add(4);
		
		MergeSort mergeSort = new MergeSort();
		
		List<Integer> mergedList = mergeSort.merge(list01, list02);
		assertEquals(expectedMergedList, mergedList);
	}
	
	@Test
	public void merge_Test_With_Two_Sorted_List_With_Failing_Case(){
		List<Integer> list01 = new ArrayList<Integer>();
		list01.add(712);
		list01.add(1009);
		
		List<Integer> list02 = new ArrayList<Integer>();
		list02.add(189);
		list02.add(461);
		
		List<Integer> expectedMergedList = new ArrayList<Integer>();
		expectedMergedList.add(189);
		expectedMergedList.add(461);
		expectedMergedList.add(712);
		expectedMergedList.add(1009);
		
		MergeSort mergeSort = new MergeSort();
		
		List<Integer> mergedList = mergeSort.merge(list01, list02);
		assertEquals(expectedMergedList, mergedList);
	}
	
	@Test
	public void merge_Test_With_The_Same_Sorted_List(){
		List<Integer> list01 = new ArrayList<Integer>();
		list01.add(1);
		list01.add(2);
		
		List<Integer> list02 = new ArrayList<Integer>();
		list02.add(1);
		list02.add(2);
		
		List<Integer> expectedMergedList = new ArrayList<Integer>();
		expectedMergedList.add(1);
		expectedMergedList.add(1);
		expectedMergedList.add(2);
		expectedMergedList.add(2);
		
		MergeSort mergeSort = new MergeSort();
		
		List<Integer> mergedList = mergeSort.merge(list01, list02);
		assertEquals(expectedMergedList, mergedList);
	}
	
	
	@Test
	public void sort_Test_With_An_Odd_List_Of_Elements_In_Descending_Order(){
		Integer[] unsortedArray = new Integer[]{1009, 987, 843, 712, 600, 537, 461, 329, 222, 189, 67};
		List<Integer> unsortedElements = new ArrayList<Integer>();
		for(Integer integer : unsortedArray){
			unsortedElements.add(integer);
		}
		
		Integer[] sortedArray = new Integer[]{67, 189, 222, 329, 461, 537, 600, 712, 843, 987, 1009};
		List<Integer> sortedElements = new ArrayList<Integer>();
		for(Integer integer : sortedArray){
			sortedElements.add(integer);
		}
		
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(unsortedElements);
		
		assertEquals(sortedElements, unsortedElements);
	}
	
}
