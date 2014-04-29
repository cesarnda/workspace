package edu.harvard.cscie124.pa3.structure;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Cloneable {

	private List<Long> a1;
	private List<Long> a2;
	
	public Solution(){
		a1 = new ArrayList<Long>();
		a2 = new ArrayList<Long>();
	}
	
	public void assignCopyToA1(List<Long> a1ToCopy){
		a1.clear();
		for(Long element : a1ToCopy){
			a1.add(element);
		}
	}
	
	public void assignCopyToA2(List<Long> a2ToCopy){
		a2.clear();
		for(Long element : a2ToCopy){
			a2.add(element);
		}
	}
	
	public void swapElements(int i, int j){
		Long elementA1 = a1.remove(i);
		Long elementA2 = a2.remove(j);

		a1.add(elementA2);
		a2.add(elementA1);
	}
	
	public Long getResidue(){
		Long s1 = getTotalSum(a1);
		Long s2 = getTotalSum(a2);
		return Math.abs(s1 - s2);
	}
	
	private Long getTotalSum(List<Long> list){
		Long totalSum = 0L;
		for(Long element : list){
			totalSum += element;
		}
		return totalSum;
	}
	
	public Solution clone(){
		Solution solution = new Solution();
		solution.assignCopyToA1(a1);
		solution.assignCopyToA2(a2);
		return solution;
	}
}
