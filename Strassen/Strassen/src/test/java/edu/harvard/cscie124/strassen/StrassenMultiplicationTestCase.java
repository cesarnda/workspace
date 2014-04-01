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
	
	private void printMatrix(String message, double[][] matrix){
		
		System.out.println("\n");
		System.out.println(message);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
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
	public void multiply_Test_With_2_Square_0_And_1_Matrices(){
		logger.info("Test with 2-size Square matrices with 0s and 1s");
		int size = 2;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_4_Square_0_And_1_Matrices(){
		logger.info("Test with 4-size Square matrices with 0s and 1s");
		int size = 4;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_8_Square_0_And_1_Matrices(){
		logger.info("Test with 8-size Square matrices with 0s and 1s");
		int size = 8;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_16_Square_0_And_1_Matrices(){
		logger.info("Test with 16-size Square matrices with 0s and 1s");
		int size = 16;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_32_Square_0_And_1_Matrices(){
		logger.info("Test with 32-size Square matrices with 0s and 1s");
		int size = 32;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_64_Square_0_And_1_Matrices(){
		logger.info("Test with 64-size Square matrices with 0s and 1s");
		int size = 64;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_2_Square_0_And_1_And_2_Matrices(){
		logger.info("Test with 2-size Square matrices with 0s, 1s and 2s");
		int size = 2;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_4_Square_0_And_1_And_2_Matrices(){
		logger.info("Test with 4-size Square matrices with 0s, 1s and 2s");
		int size = 4;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_8_Square_0_And_1_And_2_Matrices(){
		logger.info("Test with 8-size Square matrices with 0s, 1s and 2s");
		int size = 8;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_16_Square_0_And_1__And_2_Matrices(){
		logger.info("Test with 16-size Square matrices with 0s, 1s and 2s");
		int size = 16;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_32_Square_0_And_1_And_2_Matrices(){
		logger.info("Test with 32-size Square matrices with 0s, 1s and 2s");
		int size = 32;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_64_Square_0_And_1_And_2_Matrices(){
		logger.info("Test with 64-size Square matrices with 0s, 1s and 2s");
		int size = 64;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}

	
	@Test
	public void multiply_Test_With_2_Square_0_And_1_And_Negative_1_Matrices(){
		logger.info("Test with 2-size Square matrices with 0s, 1s and -1s");
		int size = 2;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_4_Square_0_And_1_And_Negative_1_Matrices(){
		logger.info("Test with 4-size Square matrices with 0s, 1s and -1s");
		int size = 4;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_8_Square_0_And_1_And_Negative_1_Matrices(){
		logger.info("Test with 8-size Square matrices with 0s, 1s and -1s");
		int size = 8;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_16_Square_0_And_1__And_Negative_1_Matrices(){
		logger.info("Test with 16-size Square matrices with 0s, 1s and -1s");
		int size = 16;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_32_Square_0_And_1_And_Negative_1_Matrices(){
		logger.info("Test with 32-size Square matrices with 0s, 1s and -1s");
		int size = 32;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	@Test
	public void multiply_Test_With_64_Square_0_And_1_And_Negative_1_Matrices(){
		logger.info("Test with 64-size Square matrices with 0s, 1s and -1s");
		int size = 64;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(areNumericMatrixEquals(expectedResult, result, 0.0001));
	}
	
	
	@Test
	public void multiply_Test_With_N_Square(){
		int[] sizes = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512};
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
