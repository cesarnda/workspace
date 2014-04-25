package edu.harvard.cscie124.pa3.structure;

public interface Heap<T>{

	public T getElementAtTop();
	public T deleteElementAtTop();
	public void insertElement(T t);
	public int size();
}
