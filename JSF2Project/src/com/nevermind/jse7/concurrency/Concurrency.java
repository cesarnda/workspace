package com.nevermind.jse7.concurrency;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Concurrency {

	public static void main(String ... args){
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of processors: " + numberOfProcessors);
		copyOnWriteArrayList_Test_With_Removal();
	}
	
	public static void copyOnWriteArrayListTest() {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println("Before deleting");
		for (String string : list) {
			System.out.println(string);
		}
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String string = iterator.next();
			if("B".equals(string)){
				iterator.remove();
			}
		}
		
		System.out.println("After deleting");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public static void copyOnWriteArrayList_Test_With_Removal() {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println("Before deleting");
		for (String string : list) {
			System.out.println(string);
		}
		Iterator<String> iterator = list.iterator();
		list.remove(1);
		
		System.out.println("After deleting");
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	
}
