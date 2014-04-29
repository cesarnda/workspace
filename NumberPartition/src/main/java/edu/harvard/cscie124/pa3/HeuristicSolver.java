package edu.harvard.cscie124.pa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class HeuristicSolver {

	public static final int MAX_ITER = 25000;
	
	protected Random random;
	
	public HeuristicSolver(){
		random = new Random();
	}
	
	public Long getTotalSum(List<Long> list){
		Long totalSum = 0L;
		for(Long element : list){
			totalSum += element;
		}
		return totalSum;
	}
	
	protected List<Long> readIntegersFromFile(String filename) throws FileNotFoundException{
		List<Long> elements = new ArrayList<Long>(100);
		Scanner scanner = new Scanner(new File(filename));
		while(scanner.hasNext()){
			//String line = scanner.nextLine();
			elements.add(scanner.nextLong());
		}
		
		return elements;
	}
	
	protected List<Long> cloneList(List<Long> list){
		List<Long> elements = new ArrayList<Long>(list.size());
		for(Long element : list){
			elements.add(element);
		}
		return elements;
	}
	
}
