package edu.harvard.cscie124.strassen;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class MatrixTestCase {


	@Test
	public void add_Test_2_Adjacent_SubMatrices(){
		double[][] matrix = new double[][]{
				{ 1,  2,  3,  4},
				{ 5,  6,  7,  8},
				{ 9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		Matrix subMatrixC21 = new Matrix(matrix, 2, 2, 2, 0);
		Matrix subMatrixC22 = new Matrix(matrix, 2, 2, 2, 2);
		
		Matrix addedMatrices = subMatrixC21.add(subMatrixC22);
		
		double[][] expectedResult = new double[][]{
										{20, 22},
										{28, 30}
							};
		assertTrue(addedMatrices.equals(expectedResult));

	}
	
	@Test
	public void equals_Test_From_4_To_1(){
		double[][] matrix = new double[][]{
				{ 1,  2,  3,  4},
				{ 5,  6,  7,  8},
				{ 9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		Matrix matrixA = new Matrix(matrix, 1, 1, 3,3);
		Matrix matrixB = new Matrix(matrix, 1, 1, 2,2);
		
		Matrix addition = matrixA.add(matrixB);
		assertEquals(27, addition.get(0, 0), 0.0001);
		
		Matrix subtraction = matrixA.subtract(matrixB);
		assertEquals(5, subtraction.get(0, 0), 0.0001);
		
		double[][] expectedAddition = new double[][]{{27}};
		double[][] expectedSubtraction = new double[][]{{5}};
		
		assertTrue(addition.equals(expectedAddition));
		assertTrue(subtraction.equals(expectedSubtraction));
	}
	
	@Test
	public void equals_Test_SubMatrices(){
		double[][] matrix = new double[][]{
				{ 1,  2,  3,  4},
				{ 5,  6,  7,  8},
				{ 9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		Matrix matrixA = new Matrix(matrix, 1, 1, 3,3);
		double[][] expectedMatrixA = new double[][]{{16}};
		assertTrue(matrixA.equals(expectedMatrixA));
		
		Matrix matrixB = new Matrix(matrix, 2,2, 1, 1);
		double[][] expectedMatrixB = new double[][]{{6, 7},{10, 11}};
		assertTrue(matrixB.equals(expectedMatrixB));
	}
	
	@Test
	public void add_Test_With_Itself(){
		double[][] matrix = new double[][]{
				{ 1,  2,  3,  4},
				{ 5,  6,  7,  8},
				{ 9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		Matrix subMatrixC21 = new Matrix(matrix);
		Matrix subMatrixC22 = new Matrix(matrix);
		
		Matrix addedMatrices = subMatrixC21.add(subMatrixC22);
		
		double[][] expectedResult = new double[][]{
										{ 2,  4,  6,  8},
										{10, 12, 14, 16},
										{18, 20, 22, 24},
										{26, 28, 30, 32}
							};
		assertTrue(addedMatrices.equals(expectedResult));

	}
	
}
