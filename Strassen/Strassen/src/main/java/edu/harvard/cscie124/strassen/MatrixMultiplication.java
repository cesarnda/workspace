package edu.harvard.cscie124.strassen;

public class MatrixMultiplication {
	
	
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
		
		return c;
	}

}
