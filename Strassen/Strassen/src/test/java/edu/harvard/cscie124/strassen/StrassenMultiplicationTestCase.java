package edu.harvard.cscie124.strassen;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StrassenMultiplicationTestCase {
	
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
		int size = 2;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_4_Square_0_And_1_Matrices(){
		int size = 4;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_8_Square_0_And_1_Matrices(){
		int size = 8;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_16_Square_0_And_1_Matrices(){
		int size = 16;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_32_Square_0_And_1_Matrices(){
		int size = 32;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_64_Square_0_And_1_Matrices(){
		int size = 64;
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_2_Square_0_And_1_And_2Matrices(){
		int size = 2;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_4_Square_0_And_1_And_2Matrices(){
		int size = 4;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_8_Square_0_And_1_And_2_Matrices(){
		int size = 8;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_16_Square_0_And_1__And_2_Matrices(){
		int size = 16;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_32_Square_0_And_1_And_2_Matrices(){
		int size = 32;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_64_Square_0_And_1_And_2_Matrices(){
		int size = 64;
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}

	
	@Test
	public void multiply_Test_With_2_Square_0_And_1_And_Negative_1_Matrices(){
		int size = 2;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_4_Square_0_And_1_And_Negative_1_Matrices(){
		int size = 4;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_8_Square_0_And_1_And_Negative_1_Matrices(){
		int size = 8;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_16_Square_0_And_1__And_Negative_1_Matrices(){
		int size = 16;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_32_Square_0_And_1_And_Negative_1_Matrices(){
		int size = 32;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_64_Square_0_And_1_And_Negative_1_Matrices(){
		int size = 64;
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	
	@Test
	public void multiply_Test_With_2_Square_In_Rage_0_To_1_Matrices(){
		int size = 2;
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		printMatrix("Expected matrix: ", expectedResult);
		printMatrix("Resulted matrix: ", result);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_4_Square_In_Rage_0_To_1_Matrices(){
		int size = 4;
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_8_Square_In_Rage_0_To_1_Matrices(){
		int size = 8;
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_16_Square_In_Rage_0_To_1_Matrices(){
		int size = 16;
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_32_Square_In_Rage_0_To_1_Matrices(){
		int size = 32;
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
	@Test
	public void multiply_Test_With_64_Square_In_Rage_0_To_1_Matrices(){
		int size = 64;
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] expectedResult = matrixMultiplication.multiply(a, b);
		double[][] result = strassenMultiplication.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, result));
	}
	
}
