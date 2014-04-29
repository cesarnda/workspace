package edu.harvard.cscie124.pa3.heuristic;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HillClimbingTestCases {

	private static final Logger logger = LoggerFactory.getLogger(HillClimbingTestCases.class);

	private static final String FILE_NAME_PREFIX = "src/test/resources/RandomInstance-";
	private static final int NUMBER_OF_PROBLEM_INSTANCES = 50;
	
	@Test
	public void getAllResidue() throws FileNotFoundException{
		HillClimbing hillClimbing = new HillClimbing();
		Set<NumberPartitionSolution> solutions = new TreeSet<NumberPartitionSolution>();
		for(int index = 1; index <= NUMBER_OF_PROBLEM_INSTANCES; index++){
			long startTime = System.currentTimeMillis();
			long residue = hillClimbing.applyHillClimbing(FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt");
			long timeTaken = System.currentTimeMillis() - startTime;
			solutions.add(new NumberPartitionSolution(timeTaken, FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt", residue, "HillClimbing"));
		}
		for(NumberPartitionSolution solution : solutions){
			logger.info("The method " + solution.getMethodUsed() + " took " + solution.getTimeTaken() + " milliseconds for file " + 
																				solution.getFilename() + " and computed the residue " + 
																				solution.getResidue());
		}
	}
	
}
