package com.nevermindcorp.algorithms.sorting;

import java.util.List;

import com.nevermindcorp.algorithms.Step;

public interface Sorting {

	public <T extends Comparable<T>>List<T> sort(List<T> list, List<Step> steps);
	
}
