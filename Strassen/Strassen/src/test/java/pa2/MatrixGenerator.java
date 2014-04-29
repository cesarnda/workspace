package edu.harvard.cscie124.strassen;

import java.util.Random;

public class MatrixGenerator {

	private Random random;
	
	public MatrixGenerator(){
		random = new Random();
	}
	
	public double[][] generateMatrixWith0And1(int rows, int columns){
		double[][] matrix = new double[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				matrix[i][j] = random.nextInt(2);
			}
		}
		
		return matrix;
	}
	
	public double[][] generateMatrixWith0And1And2(int rows, int columns){
		double[][] matrix = new double[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				matrix[i][j] = random.nextInt(3);
			}
		}
		
		return matrix;
	}
	
	public double[][] generateMatrixWith0And1AndNegative1(int rows, int columns){
		double[][] matrix = new double[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				matrix[i][j] = random.nextInt(3) - 1;
			}
		}
		
		return matrix;
	}
	
	public double[][] generateMatriInRange0To1(int rows, int columns){
		double[][] matrix = new double[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				matrix[i][j] = random.nextDouble();
			}
		}
		
		return matrix;
	}
	
}
