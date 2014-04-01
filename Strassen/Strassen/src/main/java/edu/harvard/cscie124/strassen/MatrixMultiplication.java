package edu.harvard.cscie124.strassen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatrixMultiplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MatrixMultiplication.class);

	
	/**
	 * This method receives two matrices A (m x n) and B (n x k)
	 * and returns a matrix C of length m x k, which reprents
	 * A * B.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double[][] multiply(double[][] a, double[][] b){
		long startTime = System.currentTimeMillis();
		int numberOfRowsOfA = a.length;
		int numberOfRowsOfB = b.length;
		int numberOfColumnsOfB = b[0].length;
		
		double[][] c = new double[numberOfRowsOfA][numberOfColumnsOfB];
		
		for(int i = 0; i < numberOfRowsOfA; i++){
			for(int j = 0; j < numberOfColumnsOfB; j++){
				for(int m = 0; m < numberOfRowsOfB; m++){
					c[i][j] += a[i][m] * b[m][j];
				}
			}
		}
		
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Standard multiplication took " + timeTaken + " milliseconds to multiply A(" + 
																			numberOfRowsOfA +"x" + 
																			numberOfRowsOfB + 
																			") by B(" + 
																			numberOfRowsOfB +
																			"x" + 
																			numberOfColumnsOfB +
																			")");
		
		return c;
	}

}
