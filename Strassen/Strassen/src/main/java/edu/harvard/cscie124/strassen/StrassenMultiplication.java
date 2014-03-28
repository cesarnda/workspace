package edu.harvard.cscie124.strassen;

public class StrassenMultiplication {

	/**
	 * This method multiplies two matrices A and B, assuming
	 * both of them are of size n x n, where n = 2^k.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double[][] multiply(double[][] matrixA, double[][] matrixB){
		int n = matrixA.length;
		
		double[][] matrixC = new double[n][n];
		
		if(n == 1){
			matrixC[0][0] = matrixA[0][0] * matrixB[0][0];
			return matrixC;
		}
		
		int split = n / 2;
        
		double[][] subMatrixA11 = assignCorrespondingBlocks(matrixA, 0, 0);
        double[][] subMatrixA12 = assignCorrespondingBlocks(matrixA, 0, split);
        double[][] subMatrixA21 = assignCorrespondingBlocks(matrixA, split, 0);
        double[][] subMatrixA22 = assignCorrespondingBlocks(matrixA, split, split);
        
        double[][] subMatrixB11 = assignCorrespondingBlocks(matrixB, 0, 0);
        double[][] subMatrixB12 = assignCorrespondingBlocks(matrixB, 0, split);
        double[][] subMatrixB21 = assignCorrespondingBlocks(matrixB, split, 0);
        double[][] subMatrixB22 = assignCorrespondingBlocks(matrixB, split, split);
		
        double[][] subMatrixS1  = subtract(subMatrixB12, subMatrixB22);
        double[][] subMatrixS2  = add(subMatrixA11, subMatrixA12);
        double[][] subMatrixS3  = add(subMatrixA21, subMatrixA22);
        double[][] subMatrixS4  = subtract(subMatrixB21, subMatrixB11);
        double[][] subMatrixS5  = add(subMatrixA11, subMatrixA22);
        double[][] subMatrixS6  = add(subMatrixB11, subMatrixB22);
        double[][] subMatrixS7  = subtract(subMatrixA12, subMatrixA22);
        double[][] subMatrixS8  = add(subMatrixB21, subMatrixB22);
        double[][] subMatrixS9  = subtract(subMatrixA11, subMatrixA21);
        double[][] subMatrixS10 = add(subMatrixB11, subMatrixB12);
        
        double[][] subMatrixP1 = multiply(subMatrixA11, subMatrixS1);
        double[][] subMatrixP2 = multiply(subMatrixS2, subMatrixB22);
        double[][] subMatrixP3 = multiply(subMatrixS3, subMatrixB11);
        double[][] subMatrixP4 = multiply(subMatrixA22, subMatrixS4);
        double[][] subMatrixP5 = multiply(subMatrixS5, subMatrixS6);
        double[][] subMatrixP6 = multiply(subMatrixS7, subMatrixS8);
        double[][] subMatrixP7 = multiply(subMatrixS9, subMatrixS10);
        
        double[][] subMatrixC11 = add(subtract(add(subMatrixP5, subMatrixP4), subMatrixP2), subMatrixP6);
        double[][] subMatrixC12 = add(subMatrixP1, subMatrixP2);
        double[][] subMatrixC21 = add(subMatrixP3, subMatrixP4);
        double[][] subMatrixC22 = subtract(subtract(add(subMatrixP5, subMatrixP1), subMatrixP3), subMatrixP7);
        
		return matrixC;
	}
	
	public double[][] add(double[][] matrixA, double[][] matrixB){
		int m = matrixA.length;
		int n = matrixA[0].length;
		double[][] result = new double[m][n];
		
		for(int row = 0; row < m; row++){
			for(int column = 0; column < n; column++){
				result[row][column] = matrixA[row][column] + matrixB[row][column];
			}
		}
		return result;
	}
	
	public double[][] subtract(double[][] matrixA, double[][] matrixB){
		int m = matrixA.length;
		int n = matrixA[0].length;
		double[][] result = new double[m][n];
		
		for(int row = 0; row < m; row++){
			for(int column = 0; column < n; column++){
				result[row][column] = matrixA[row][column] - matrixB[row][column];
			}
		}
		return result;
	}
	
	public double[][] assignCorrespondingBlocks(double[][] fullMatrix, int startRow, int startColumn){
		int n = fullMatrix.length / 2;
		double[][] subMatrix = new double[n][n];
		int rowLimit = startRow + n;
		int columnLimit = startColumn  + n;
		
		
		for(int row = startRow; row < rowLimit; row++){
			for(int column = startColumn; column < columnLimit; column++){
				subMatrix[row - startRow][column - startColumn] = fullMatrix[row][column];
			}
		}
		
		return subMatrix;
	}
	
}
