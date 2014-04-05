package edu.harvard.cscie124.strassen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrassenMultiplicationTestCase {
	private static final Logger logger = LoggerFactory.getLogger(StrassenMultiplicationTestCase.class);

	private GeneralStrassenTestCase strassenTestCases;
	
	public StrassenMultiplicationTestCase(){
		strassenTestCases = new GeneralStrassenTestCase();
	}
	
	
	@Test
	public void runTestCasesWithNaiveStrassen(){
		strassenTestCases.setStrassent(new MatrixMultiplication());
		logger.info("Running Straight Multiplication");
		//strassenTestCases.runTestCases();
		
		strassenTestCases.setStrassent(new StrassenMultiplication());
		logger.info("Running Naive Strassen");
		//strassenTestCases.runTestCases();
		
		strassenTestCases.setStrassent(new MatrixStrassenMultiplication());
		logger.info("Running Matrix Strassen");
		//strassenTestCases.runTestCases();
		
		strassenTestCases.setStrassent(new StrassenMultiplicationWithThreshold(64));
		//strassenTestCases.runTestCases();
		
		strassenTestCases.setStrassent(new StrassenMultiplicationWithThreshold(16));
		strassenTestCases.runTestCases();
	}
	
	
	
}
