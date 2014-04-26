package edu.harvard.cscie124.pa3.structure;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class AbstractHeap<T> implements Heap<T>, Comparator<T> {

	private PriorityQueue<T> queue;
	
	public AbstractHeap(){
		queue = new PriorityQueue<T>(100, this);
	}
	
	public AbstractHeap(final Collection<T> elements){
		this();
		for(T element : elements){
			insertElement(element);
		}
	}
	
	/**
	 * Expected running time is O(1)
	 */
	@Override
	public T getElementAtTop() {
		return queue.peek();
	}

	/**
	 * Expected running time is O(log n)
	 */
	@Override
	public T deleteElementAtTop() {
		return queue.poll();
	}

	/**
	 * Expected running time is O(log n)
	 */
	@Override
	public void insertElement(T t) {
		queue.add(t);
	}
	
	@Override
	public int size(){
		return queue.size();
	}
	
	@Override
	public void clear(){
		queue.clear();
	}
	
}
