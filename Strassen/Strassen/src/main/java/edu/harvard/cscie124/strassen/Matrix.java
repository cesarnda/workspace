package edu.harvard.cscie124.strassen;

import java.util.Arrays;

public class Matrix {
	
	private double matrix[][];
	
	public Matrix(int m, int n){
		matrix = new double[m][n];
	}

	public void set(int row, int column, double value){
		matrix[row][column] = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}
	
	
}
