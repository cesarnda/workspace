package edu.harvard.cscie124.strassen;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralStrassenTestCase {
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralStrassenTestCase.class);
	
	private MatrixMultiplication matrixMultiplication;
	private MatrixGenerator matrixGenerator;
	private Strassen strassenMultiplication;
	private boolean validate;
	
	//int[] sizes = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
	int[] sizes = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
	//int[] sizes = new int[]{2048, 4096, 8192,};
	int[] sizesOdd = new int[]{3, 9, 17, 33, 65, 129, 257, 513, 1025};


	
	public GeneralStrassenTestCase(){
		matrixMultiplication = new MatrixMultiplication();
		matrixGenerator = new MatrixGenerator();
	}
	
	public void setStrassent(Strassen strassen){
		this.strassenMultiplication = strassen;
	}
	
	public void runNonSquareTestCases(){
		multiply_Test_With_N_In_Range_0_To_1_Matrices();
		multiply_Test_With_0_And_1_And_Negative_1_Matrices();
		multiply_Test_With_0_And_1_And_2_Matrices();
		multiply_Test_With_0_And_1_Matrices();
	}
	
	public void runTestCases(){
		multiply_Test_With_Identity_Matrix();
		multiply_Test_Squaring();
		multiply_Test_With_N_Square_0_And_1_Matrices();
		multiply_Test_With_N_Square_0_And_1_And_2_Matrices();
		multiply_Test_With_N_Square_0_And_1_And_Negative_1_Matrices();
		multiply_Test_With_N_Square_In_Range_0_To_1_Matrices();
	}
	
	
	public void multiply_Test_With_Identity_Matrix(){
		logger.info("Test with 2-size Square matrix and identity matrix");

		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] b = new double[][]{{1,0},{0,1}};
		
		Matrix result = strassenMultiplication.multiply(a, b);
		assertTrue(result.equals(a, 0.0001));
	}

	
	public void multiply_Test_Squaring(){
		logger.info("Test with 2-size Square matrix and itsel");
		double[][] a = new double[][]{{1,2},{3,4}};
		double[][] expectedResult = new double[][]{{7,10},{15,22}};
		
		Matrix result = strassenMultiplication.multiply(a, a);
		assertTrue(result.equals(expectedResult, 0.0001));
	}
	
	public void multiply_Test_With_N_Square_0_And_1_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_0_And_1_Matrices(size);
		}
	}
	
	public void multiply_Test_With_N_Square_0_And_1_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices with 0 and 1");
		double[][] a = matrixGenerator.generateMatrixWith0And1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1(size, size);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	
	
	public void multiply_Test_With_N_Square_0_And_1_And_2_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_0_And_1_And_2_Matrices(size);
		}
	}

	public void multiply_Test_With_N_Square_0_And_1_And_2_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices with 0, 1 and 2");
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(size, size);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	
	public void multiply_Test_With_N_Square_0_And_1_And_Negative_1_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_0_And1_And_Negative_1_Matrices(size);
		}
	}
	
	public void multiply_Test_With_N_Square_0_And1_And_Negative_1_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices with 0, 1 and -1");
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(size, size);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	
	public void multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(){
		for(int size : sizes){
			multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(size);
		}
	}
	
	
	public void multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(int size){
		logger.info("Test with " + size + "-size Square matrices in range 0 to 1");
		double[][] a = matrixGenerator.generateMatriInRange0To1(size, size);
		double[][] b = matrixGenerator.generateMatriInRange0To1(size, size);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	public void multiply_Test_With_N_In_Range_0_To_1_Matrices(){
		for(int size : sizesOdd){
			multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(size, size, size);
		}
	}
	
	
	public void multiply_Test_With_N_Square_In_Range_0_To_1_Matrices(int rowsOfA, int rowsOfB, int columnsOfB){
		logger.info("Test with A(" + rowsOfA + ", " + rowsOfB + ")  and B(" + rowsOfB + ", " + columnsOfB + ") matrices in range 0 to 1");
		double[][] a = matrixGenerator.generateMatriInRange0To1(rowsOfA, rowsOfB);
		double[][] b = matrixGenerator.generateMatriInRange0To1(rowsOfB, columnsOfB);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	public void multiply_Test_With_0_And_1_And_Negative_1_Matrices(){
		for(int size : sizesOdd){
			multiply_Test_With__0_And1_And_Negative_1_Matrices(size, size, size);
		}
	}
	
	public void multiply_Test_With__0_And1_And_Negative_1_Matrices(int rowsOfA, int rowsOfB, int columnsOfB){
		logger.info("Test with A(" + rowsOfA + ", " + rowsOfB + ")  and B(" + rowsOfB + ", " + columnsOfB + ") matrices with 0, 1 and -1");
		double[][] a = matrixGenerator.generateMatrixWith0And1AndNegative1(rowsOfA, rowsOfB);
		double[][] b = matrixGenerator.generateMatrixWith0And1AndNegative1(rowsOfB, columnsOfB);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	public void multiply_Test_With_0_And_1_And_2_Matrices(){
		for(int size : sizesOdd){
			multiply_Test_With_0_And_1_And_2_Matrices(size, size, size);
		}
	}

	public void multiply_Test_With_0_And_1_And_2_Matrices(int rowsOfA, int rowsOfB, int columnsOfB){
		logger.info("Test with A(" + rowsOfA + ", " + rowsOfB + ")  and B(" + rowsOfB + ", " + columnsOfB + ") matrices with 0, 1 and 2");
		double[][] a = matrixGenerator.generateMatrixWith0And1And2(rowsOfA, rowsOfB);
		double[][] b = matrixGenerator.generateMatrixWith0And1And2(rowsOfB, columnsOfB);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}
	
	public void multiply_Test_With_0_And_1_Matrices(){
		for(int size : sizesOdd){
			multiply_Test_With_0_And_1_Matrices(size, size, size);
		}
	}
	
	public void multiply_Test_With_0_And_1_Matrices(int rowsOfA, int rowsOfB, int columnsOfB){
		logger.info("Test with A(" + rowsOfA + ", " + rowsOfB + ")  and B(" + rowsOfB + ", " + columnsOfB + ") matrices with 0 and 1");
		double[][] a = matrixGenerator.generateMatrixWith0And1(rowsOfA, rowsOfB);
		double[][] b = matrixGenerator.generateMatrixWith0And1(rowsOfB, columnsOfB);
		Matrix result = strassenMultiplication.multiply(a, b);
		if(validate){
			double[][] expectedResult = matrixMultiplication.multiplyNaive(a, b);
			assertTrue(result.equals(expectedResult, 0.0001));
		}
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}
}
