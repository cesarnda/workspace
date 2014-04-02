package edu.harvard.cscie124.strassen;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Matrix {
	
	private static final Logger logger = LoggerFactory.getLogger(Matrix.class);

	
	private final double matrix[][];
	private final int numberOfRows;
	private final int numberOfColumns;
	private final int startRow;
	private final int startColumn;
	private final boolean composedMatrix;
	private final int sizeOfSubMatrix;
	private final List<Matrix> subMatrices;
	
	/**
	 * The four matrices must have the same number of columns and rows and these values
	 * must be n = 2^k
	 * 
	 * @param C11
	 * @param C12
	 * @param C21
	 * @param C22
	 */
	public Matrix(Matrix C11, Matrix C12, Matrix C21, Matrix C22){
		this.composedMatrix = true;
		this.sizeOfSubMatrix = C11.getNumberOfRows();
		this.numberOfRows = 2 * sizeOfSubMatrix;
		this.numberOfColumns = 2 * sizeOfSubMatrix;
		this.startRow = 0;
		this.startColumn = 0;
		this.matrix = null;
		this.subMatrices = new LinkedList<Matrix>();
		this.subMatrices.add(C11);
		this.subMatrices.add(C12);
		this.subMatrices.add(C21);
		this.subMatrices.add(C22);
	}
	
	public Matrix(Matrix matrix, int numberOfRows, int numberOfColumns, int startRow, int startColumn){
		this(matrix.matrix, numberOfRows, numberOfColumns, startRow + matrix.startRow, startColumn + matrix.startColumn);
	}
	
	public Matrix(double[][] matrix){
		this(matrix, matrix.length, matrix[0].length, 0, 0);
	}
	
	public Matrix(double[][] matrix, int numberOfRows, int numberOfColumns, int startRow, int startColumn){
		this.matrix = matrix;
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.composedMatrix = false;
		this.sizeOfSubMatrix = 0;
		this.subMatrices = null;
	}

	public double get(int row, int column){
		if(composedMatrix){
			return getElementFromCompose(row, column);
		}
		logger.debug("Getting (" + row + ", " + column +")");
		logger.debug("I(" + startRow + ", " + startColumn + ")");
		logger.debug("Size: " + matrix.length + " x " + matrix[0].length);
		return matrix[startRow + row][startColumn + column];
	}
	
	private double getElementFromCompose(int row, int column){
		if(row < sizeOfSubMatrix){
			if(column < sizeOfSubMatrix){
				logger.debug("Using C11");
				return subMatrices.get(0).get(row, column);
			}
			logger.debug("Using C12");
			return subMatrices.get(1).get(row, column - sizeOfSubMatrix);
		}
		row -= sizeOfSubMatrix;
		if(column < sizeOfSubMatrix){
			logger.debug("Using C21");
			return subMatrices.get(2).get(row, column);
		}
		logger.debug("Using C22");
		return subMatrices.get(3).get(row, column - sizeOfSubMatrix);		
	}
		
	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public boolean equals(Matrix matrix, double delta){
		int numberOfRows = matrix.getNumberOfRows();
		int numberOfColumns = matrix.getNumberOfColumns();
		for(int i = 0; i < numberOfRows; i++){
			for(int j = 0; j < numberOfColumns; j++){
				logger.debug("i: " + i + ", j: " + j);
				double a = get(i,j);
				double b = matrix.get(i, j);
				if(Math.abs(a - b) > delta){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean equals(Matrix matrix){
		return equals(matrix, 0.0001);
	}

	public boolean equals(double[][] matrix, double delta){
		return equals(new Matrix(matrix), delta);
	}
	
	public boolean equals(double[][] matrix){
		return equals(matrix, 0.0001);
	}
	
	public Matrix add(Matrix matrix){
		double[][] result = new double[getNumberOfRows()][getNumberOfColumns()];
		
		for(int i = 0; i < getNumberOfRows(); i++){
			for(int j = 0; j < getNumberOfColumns(); j++){
				result[i][j] = get(i,j) + matrix.get(i, j);
			}
		}
		
		return new Matrix(result, this.numberOfColumns, this.numberOfColumns, 0, 0);
	}
	
	public Matrix subtract(Matrix matrix){
		double[][] result = new double[this.numberOfRows][this.numberOfColumns];
		
		for(int i = 0; i < getNumberOfRows(); i++){
			for(int j = 0; j < getNumberOfColumns(); j++){
				result[i][j] = get(i,j) - matrix.get(i, j);
			}
		}
		
		return new Matrix(result, this.numberOfColumns, this.numberOfColumns, 0, 0);
	}
	
	public static double[][] add(double[][] matrixA, double[][] matrixB){
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
	
	public static double[][] subtract(double[][] matrixA, double[][] matrixB){
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
	
}
