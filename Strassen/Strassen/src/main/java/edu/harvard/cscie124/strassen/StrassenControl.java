package edu.harvard.cscie124.strassen;

import java.io.File;
import java.util.Scanner;

public class StrassenControl {
	
	private double[][] matrixA;
	private double[][] matrixB;
	private int dimension;
	private Strassen strassen;
	
	public StrassenControl(){
		strassen = new StrassenMultiplicationWithThresholdAndPadding(32);
	}

	public static void main(String[] args) throws Exception{
		String dimensionString = args[1];
		String inputFile = args[2];
		StrassenControl control = new StrassenControl();
		control.initializeMatrices(dimensionString);
		control.readMatrices(inputFile);
		
	}
	
	public void multiplyAndPrintResult(){
		Matrix result = strassen.multiply(matrixA, matrixB);
		for(int i = 0; i < dimension; i++){
			for(int j = 0; j < dimension; j++){
				System.out.println(result.get(i, j));
			}
		}
	}
	
	public void readMatrices(String fileName) throws Exception{
		Scanner scanner = null;
		try{
			scanner = new Scanner(new File(fileName));
			for(int i = 0; i < dimension; i++){
				for(int j = 0; j < dimension; j++){
					matrixA[i][j] = scanner.nextDouble();
				}
			}
			
			for(int i = 0; i < dimension; i++){
				for(int j = 0; j < dimension; j++){
					matrixB[i][j] = scanner.nextDouble();
				}
			}
			
		}finally{
			if(scanner != null){
				scanner.close();
			}
		}
	}
	
	public void initializeMatrices(String dimensionString){
		dimension = Integer.parseInt(dimensionString);
		matrixA = new double[dimension][dimension];
		matrixB = new double[dimension][dimension];
		
		
	}

}
