package edu.harvard.cscie124.sorting;

import java.util.List;

public interface Sorter {

	public <T extends Comparable<? super T>> void sort(List<T> unsortedList);
}
