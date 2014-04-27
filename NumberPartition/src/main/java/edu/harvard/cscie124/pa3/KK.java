package edu.harvard.cscie124.pa3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.harvard.cscie124.pa3.heuristic.KarmarkarKarp;

public class KK {

	private KarmarkarKarp karmarkarKarp;
	
	public KK(){
		karmarkarKarp = new KarmarkarKarp();
	}
	
	public static void main(String[] args) {
		KK kk = new KK();
		long residue = kk.applyKarmarkarKarp(args[0]);
		System.out.println(residue);
	}
	
	public long applyKarmarkarKarp(String filename){
		List<Long> elements = readIntegersFromFile(filename);
		return karmarkarKarp.getResidue(elements);
	}
	
	private List<Long> readIntegersFromFile(String filename){
		List<Long> elements = new ArrayList<Long>(100);
		Scanner scanner = new Scanner(filename);
		while(scanner.hasNext()){
			elements.add(scanner.nextLong());
		}
		
		return elements;
	}
	
	

}
