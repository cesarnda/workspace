package edu.harvard.cscie124.strassen;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MatrixMultiplicationTestCase {
	
	@Test
	public void multiply_Test_With_Identity_Matrix(){
		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] b = new double[][]{{1,0},{0,1}};
		
		MatrixMultiplication matrixMultiplciation = new MatrixMultiplication();
		double c[][] = matrixMultiplciation.multiply(a, b);
		assertTrue(Arrays.deepEquals(a, c));
	}

	@Test
	public void multiply_Test_Squaring(){
		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] expectedResult = new double[][]{{7,10},{15,22}};
		
		MatrixMultiplication matrixMultiplciation = new MatrixMultiplication();
		double c[][] = matrixMultiplciation.multiply(a, a);
		assertTrue(Arrays.deepEquals(expectedResult, c));
	}
	
	@Test
	public void multiply_Test_With_Different_Dimensions(){
		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] b = new double[][]{{5,6, 7},{8, 9, 10}};
		double[][] expectedResult = new double[][]{{21, 24, 27},{47, 54, 61}};
		
		MatrixMultiplication matrixMultiplciation = new MatrixMultiplication();
		double c[][] = matrixMultiplciation.multiply(a, b);
		assertTrue(Arrays.deepEquals(expectedResult, c));
	}
	
}
