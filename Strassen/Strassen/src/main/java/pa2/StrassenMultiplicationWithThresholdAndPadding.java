package edu.harvard.cscie124.strassen;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrassenMultiplicationWithThresholdAndPadding implements Strassen{

	private static final Logger logger = LoggerFactory.getLogger(StrassenMultiplicationWithThreshold.class);

	private int threshold;
	private MatrixMultiplication matrixMultiplication;

	public StrassenMultiplicationWithThresholdAndPadding(int threshold){
		this();
		this.threshold = threshold;
	}

	public StrassenMultiplicationWithThresholdAndPadding(){
		matrixMultiplication = new MatrixMultiplication();
	}

	@Override
	public Matrix multiply(double[][] matrixA, double[][] matrixB){
		int numberOfRowsOfA = matrixA.length;
		int numberOfRowsOfB = matrixB.length;
		int numberOfColumnsOfB = matrixB[0].length;
		long startTime = System.currentTimeMillis();
		boolean requiredPadding = requiresPadding(numberOfRowsOfA, numberOfRowsOfB, numberOfColumnsOfB);
		if(requiredPadding){
			int newSize = getNewSize(numberOfRowsOfA, numberOfRowsOfB, numberOfColumnsOfB);
			matrixA = padMatrix(matrixA, newSize);
			matrixB = padMatrix(matrixB, newSize);
		}

		double[][] result = multiplyDivideAndConquer(matrixA, matrixB);

		if(requiredPadding){
			result = removePadding(result, numberOfRowsOfA, numberOfColumnsOfB);
		}
		long timeTaken = System.currentTimeMillis() - startTime;
	/*	logger.info("Naive Strassen multiplication took " + timeTaken + " milliseconds to multiply A(" + 
				numberOfRowsOfA +"x" + 
				numberOfRowsOfB + 
				") by B(" + 
				numberOfRowsOfB +
				"x" + 
				numberOfColumnsOfB +
				") with threshold " + threshold);*/

		return new Matrix(result);
	}

	public double[][] removePadding(double[][] matrix, int numberOfRows, int numberOfColumns){
		double[][] newMatrix = new double[numberOfRows][numberOfColumns];

		for(int i = 0; i < numberOfRows; i++){
			for(int j = 0; j < numberOfColumns; j++){
				newMatrix[i][j] = matrix[i][j];
			}
		}

		return newMatrix;
	}

	public double[][] padMatrix(double[][] matrix, int newSize){
		int numberOfRows = matrix.length;
		int numberOfColumns = matrix[0].length;
		if(numberOfRows == newSize && numberOfColumns == newSize){
			return matrix;
		}

		double[][] newMatrix = new double[newSize][newSize];

		for(int i = 0; i < numberOfRows; i++){
			for(int j = 0; j < numberOfColumns; j++){
				newMatrix[i][j] = matrix[i][j];
			}
		}
		return newMatrix;
	}

	public int getNewSize(int rowsOfA, int rowsOfB, int columnsOfB){
		int[] sizes = new int[]{rowsOfA, rowsOfB, columnsOfB};
		Arrays.sort(sizes);
		int newSize = 1;
		while (newSize < sizes[2]){
			newSize <<= 1;
		}
		//logger.info("Padding was required, new square size is " + newSize);
		return newSize;
	}

	public boolean requiresPadding(int rowsOfA, int rowsOfB, int columnsOfB){
		if((rowsOfA & (rowsOfA - 1)) != 0){
			return true;
		}

		if((rowsOfB & (rowsOfB - 1)) != 0){
			return true;
		}

		if((columnsOfB & (columnsOfB - 1)) != 0){
			return true;
		}
		return false;
	}

	/**
	 * This method multiplies two matrices A and B, assuming
	 * both of them are of size n x n, where n = 2^k.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double[][] multiplyDivideAndConquer(double[][] matrixA, double[][] matrixB){
		int n = matrixA.length;

		double[][] matrixC = new double[n][n];

		if(n <= threshold){
			return matrixMultiplication.multiplyNaive(matrixA, matrixB);
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

		double[][] subMatrixP1 = multiplyDivideAndConquer(subMatrixA11, subMatrixS1);
		double[][] subMatrixP2 = multiplyDivideAndConquer(subMatrixS2, subMatrixB22);
		double[][] subMatrixP3 = multiplyDivideAndConquer(subMatrixS3, subMatrixB11);
		double[][] subMatrixP4 = multiplyDivideAndConquer(subMatrixA22, subMatrixS4);
		double[][] subMatrixP5 = multiplyDivideAndConquer(subMatrixS5, subMatrixS6);
		double[][] subMatrixP6 = multiplyDivideAndConquer(subMatrixS7, subMatrixS8);
		double[][] subMatrixP7 = multiplyDivideAndConquer(subMatrixS9, subMatrixS10);

		double[][] subMatrixC11 = add(subtract(add(subMatrixP5, subMatrixP4), subMatrixP2), subMatrixP6);
		double[][] subMatrixC12 = add(subMatrixP1, subMatrixP2);
		double[][] subMatrixC21 = add(subMatrixP3, subMatrixP4);
		double[][] subMatrixC22 = subtract(subtract(add(subMatrixP5, subMatrixP1), subMatrixP3), subMatrixP7);

		assembleBigMatrix(matrixC, subMatrixC11, 0, 0);
		assembleBigMatrix(matrixC, subMatrixC12, 0, split);
		assembleBigMatrix(matrixC, subMatrixC21, split, 0);
		assembleBigMatrix(matrixC, subMatrixC22, split, split);

		return matrixC;
	}

	public void assembleBigMatrix(double[][] fullMatrix, double[][] subMatrix, int startRow, int startColumn){
		int n = subMatrix.length;
		int rowLimit = startRow + n;
		int columnLimit = startColumn  + n;

		for(int row = startRow; row < rowLimit; row++){
			for(int column = startColumn; column < columnLimit; column++){
				fullMatrix[row][column] = subMatrix[row - startRow][column - startColumn];
			}
		}
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

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
