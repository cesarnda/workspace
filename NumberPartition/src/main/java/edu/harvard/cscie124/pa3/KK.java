package edu.harvard.cscie124.pa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.harvard.cscie124.pa3.heuristic.KarmarkarKarp;

public class KK extends HeuristicSolver{

	private KarmarkarKarp karmarkarKarp;
	
	public KK(){
		karmarkarKarp = new KarmarkarKarp();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		KK kk = new KK();
		long residue = kk.applyKarmarkarKarp(args[0]);
		System.out.println(residue);
	}
	
	public long applyKarmarkarKarp(String filename) throws FileNotFoundException{
		List<Long> elements = readIntegersFromFile(filename);
		return karmarkarKarp.getResidue(elements);
	}

}
