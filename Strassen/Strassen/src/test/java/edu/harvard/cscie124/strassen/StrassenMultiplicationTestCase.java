package edu.harvard.cscie124.strassen;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrassenMultiplicationTestCase {
	private static final Logger logger = LoggerFactory.getLogger(StrassenMultiplicationTestCase.class);

	private MatrixMultiplication matrixMultiplication;
	private StrassenMultiplication strassenMultiplication;
	private MatrixGenerator matrixGenerator;
	int[] sizes = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512};
	
	private boolean areNumericMatrixEquals(double[][] matrixA, double[][] matrixB, double delta){
		for(int i = 0; i < matrixA.length; i++){
			for(int j = 0; j < matrixA[0].length; j++){
				if(matrixA[i][j] - matrixB[i][j] > delta){
					return false;
				}
			}
		}
		return true;
	}
	
	@Before
	public void init(){
		matrixMultiplication = new MatrixMultiplication();
		strassenMultiplication = new StrassenMultiplication(); 
		matrixGenerator = new MatrixGenerator();
	}
	
	@Test
	public void multiply_Test_With_Identity_Matrix(){
		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] b = new double[][]{{1,0},{0,1}};
		
		double c[][] = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(a, c));
	}

	@Test
	public void multiply_Test_Squaring(){
		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] expectedResult = new double[][]{{7,10},{15,22}};
		
		double c[][] = strassenMultiplication.multiply(a, a);
		assertTrue(Arrays.deepEquals(expectedResult, c));
	}
	
	@Test
	public void multiply_Test_With_N_Square_0_And_1_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_0_And_1_Matrices(size);
		}
	}
	
	public void multiply_Test_With_N_Square_0_And_1_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices with 0 and 1");
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	
	@Test
	public void multiply_Test_With_N_Square_0_And_1_And_2_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_0_And_1_And_2_Matrices(size);
		}
	}

	public void multiply_Test_With_N_Square_0_And_1_And_2_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices with 0, 1 and 2");
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_N_Square_0_And_1_And_Negative_1_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_0_And1_And_Negative_1_Matrices(size);
		}
	}
	
	public void multiply_Test_With_N_Square_0_And1_And_Negative_1_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices with 0, 1 and -1");
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	
	@Test
	public void multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(size);
		}
	}
	
	
	public void multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices in range 0 to 1");
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
}
