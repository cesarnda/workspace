package edu.harvard.cscie124.pa3.structure;


public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T>{

	@Override
	public int compare(T arg0, T arg1) {
		if(arg0.compareTo(arg1) < 0){
			return 1;
		}
		if(arg0.compareTo(arg1) > 0){
			return -1;
		}
		return 0;
	}

}
