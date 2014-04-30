package edu.harvard.cscie124.pa3.heuristic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.harvard.cscie124.pa3.AbstractTestCases;

public class HillClimbingTestCases extends AbstractTestCases{


	private static final String FILE_NAME_PREFIX = "src/test/resources/RandomInstance-";
	private static final int NUMBER_OF_PROBLEM_INSTANCES = 50;
	
	@Test
	public void getAllResidue() throws FileNotFoundException{
		HillClimbing hillClimbing = new HillClimbing();
		List<NumberPartitionSolution> solutions = new ArrayList<NumberPartitionSolution>();
		for(int index = 1; index <= NUMBER_OF_PROBLEM_INSTANCES; index++){
			long startTime = System.currentTimeMillis();
			long residue = hillClimbing.applyHillClimbing(FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt");
			long timeTaken = System.currentTimeMillis() - startTime;
			solutions.add(new NumberPartitionSolution(timeTaken, FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt", residue, "HillClimbing"));
		}
		printSolutions(solutions);
	}
	
}
