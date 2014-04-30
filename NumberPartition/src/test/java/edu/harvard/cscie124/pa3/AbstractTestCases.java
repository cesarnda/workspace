package edu.harvard.cscie124.pa3;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.cscie124.pa3.heuristic.NumberPartitionSolution;

public class AbstractTestCases {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractTestCases.class);

	
	public void printSolutions(List<NumberPartitionSolution> solutions){
		for(NumberPartitionSolution solution : solutions){
			logger.info("The method " + solution.getMethodUsed() + " took " + solution.getTimeTaken() + " milliseconds for file " + 
																				solution.getFilename() + " and computed the residue " + 
																				solution.getResidue());
		}
	}

}
