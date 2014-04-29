package edu.harvard.cscie124.strassen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatrixStrassenMultiplication implements Strassen {
	
	private static final Logger logger = LoggerFactory.getLogger(MatrixStrassenMultiplication.class);
	
	@Override
	public Matrix multiply(double[][] matrixA, double[][] matrixB){
		int numberOfRowsOfA = matrixA.length;
		int numberOfRowsOfB = matrixB.length;
		int numberOfColumnsOfB = matrixB[0].length;
		long startTime = System.currentTimeMillis();
		Matrix result = multiplyDivideAndConquer(	new Matrix(matrixA, numberOfRowsOfA, numberOfRowsOfB, 0, 0), 
														new Matrix(matrixB, numberOfRowsOfB, numberOfColumnsOfB, 0, 0));
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Matrix Strassen multiplication took " + timeTaken + " milliseconds to multiply A(" + 
				numberOfRowsOfA +"x" + 
				numberOfRowsOfB + 
				") by B(" + 
				numberOfRowsOfB +
				"x" + 
				numberOfColumnsOfB +
				")");
		
		
		
		return result;
	}
	
	
	public Matrix multiplyDivideAndConquer(Matrix matrixA, Matrix matrixB){
		int n = matrixA.getNumberOfRows();
		
		
		if(n == 1){
			double[][] matrixC = new double[][]{{matrixA.get(0,0) * matrixB.get(0,0)}};
			return new Matrix(matrixC, 1, 1, 0, 0);
		}
		
		int split = n / 2;
        
		Matrix subMatrixA11 = new Matrix(matrixA, split, split, 0, 0);
        Matrix subMatrixA12 = new Matrix(matrixA, split, split, 0, split);
        Matrix subMatrixA21 = new Matrix(matrixA, split, split, split, 0);
        Matrix subMatrixA22 = new Matrix(matrixA, split, split, split, split);
        
        Matrix subMatrixB11 = new Matrix(matrixB, split, split, 0, 0);
        Matrix subMatrixB12 = new Matrix(matrixB, split, split, 0, split);
        Matrix subMatrixB21 = new Matrix(matrixB, split, split, split, 0);
        Matrix subMatrixB22 = new Matrix(matrixB, split, split, split, split);
		
        Matrix subMatrixS1  = subMatrixB12.subtract(subMatrixB22);
        Matrix subMatrixS2  = subMatrixA11.add(subMatrixA12);
        Matrix subMatrixS3  = subMatrixA21.add(subMatrixA22);
        Matrix subMatrixS4  = subMatrixB21.subtract(subMatrixB11);
        Matrix subMatrixS5  = subMatrixA11.add(subMatrixA22);
        Matrix subMatrixS6  = subMatrixB11.add(subMatrixB22);
        Matrix subMatrixS7  = subMatrixA12.subtract(subMatrixA22);
        Matrix subMatrixS8  = subMatrixB21.add(subMatrixB22);
        Matrix subMatrixS9  = subMatrixA11.subtract(subMatrixA21);
        Matrix subMatrixS10 = subMatrixB11.add(subMatrixB12);
        
        Matrix subMatrixP1 = multiplyDivideAndConquer(subMatrixA11, subMatrixS1);
        Matrix subMatrixP2 = multiplyDivideAndConquer(subMatrixS2, subMatrixB22);
        Matrix subMatrixP3 = multiplyDivideAndConquer(subMatrixS3, subMatrixB11);
        Matrix subMatrixP4 = multiplyDivideAndConquer(subMatrixA22, subMatrixS4);
        Matrix subMatrixP5 = multiplyDivideAndConquer(subMatrixS5, subMatrixS6);
        Matrix subMatrixP6 = multiplyDivideAndConquer(subMatrixS7, subMatrixS8);
        Matrix subMatrixP7 = multiplyDivideAndConquer(subMatrixS9, subMatrixS10);
        
        Matrix subMatrixC11 = subMatrixP5.add(subMatrixP4).subtract(subMatrixP2).add(subMatrixP6);
        Matrix subMatrixC12 = subMatrixP1.add(subMatrixP2);
        Matrix subMatrixC21 = subMatrixP3.add(subMatrixP4);
        Matrix subMatrixC22 = subMatrixP5.add(subMatrixP1).subtract(subMatrixP3).subtract(subMatrixP7);
        
		return new Matrix(subMatrixC11, subMatrixC12, subMatrixC21, subMatrixC22);
	}

}
