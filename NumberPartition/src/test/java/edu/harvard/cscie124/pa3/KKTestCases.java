package edu.harvard.cscie124.pa3;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KKTestCases {
	
	private static final Logger logger = LoggerFactory.getLogger(KKTestCases.class);

	private static final String FILE_NAME_PREFIX = "src/test/resources/RandomInstance-";
	private static final int NUMBER_OF_PROBLEM_INSTANCES = 50;
	
	@Test
	public void getAllResidue() throws FileNotFoundException{
		KK kk = new KK();
		for(int index = 1; index <= NUMBER_OF_PROBLEM_INSTANCES; index++){
			long startTime = System.currentTimeMillis();
			long residue = kk.applyKarmarkarKarp(FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt");
			long timeTaken = System.currentTimeMillis() - startTime;
			logger.info("Residue for " + FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt is " + residue + " in " + timeTaken + " milliseconds");
		}
	}

}
