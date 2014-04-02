package edu.harvard.cscie124.strassen;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

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
