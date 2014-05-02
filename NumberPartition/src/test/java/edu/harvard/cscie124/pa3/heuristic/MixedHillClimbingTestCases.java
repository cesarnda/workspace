package edu.harvard.cscie124.pa3.heuristic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.harvard.cscie124.pa3.AbstractTestCases;

public class MixedHillClimbingTestCases extends AbstractTestCases {

	private static final String FILE_NAME_PREFIX = "src/test/resources/RandomInstance-";
	private static final int NUMBER_OF_PROBLEM_INSTANCES = 50;
	
	@Test
	public void getAllResidue() throws FileNotFoundException{
		MixedHillClimbing mixedHillClimbing = new MixedHillClimbing();
		List<NumberPartitionSolution> solutions = new ArrayList<NumberPartitionSolution>();
		for(int index = 1; index <= NUMBER_OF_PROBLEM_INSTANCES; index++){
			long startTime = System.currentTimeMillis();
			long residue = mixedHillClimbing.getResidue(FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt");
			long timeTaken = System.currentTimeMillis() - startTime;
			solutions.add(new NumberPartitionSolution(timeTaken, FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt", residue, "MixedHillClimbing"));
		}
		printSolutions(solutions);
	}
}