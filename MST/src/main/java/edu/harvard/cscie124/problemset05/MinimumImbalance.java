package edu.harvard.cscie124.problemset05;

public class MinimumImbalance {

	public static void main(String[] args) {
		double[] array = new double[]{1, 2, 3, 4, 5};
		new MinimumImbalance().getMinimumImbalance(array, array.length);
	}
	
	
	public double getMinimumImbalance(double[] array, int k){
		double minimumImbalance = 0.0;
		
		double[][] matrixWithAllSums = new double[k + 1][array.length];
		double[] arrayOfAverages = new double[k];
		double total = 0.0;
		
		for(int index = 0; index < array.length; index++){
			total += array[index];
		}
		
		for(int index = 0; index < k; index++){
			arrayOfAverages[index] = total / (index + 2);  
		}
		
		matrixWithAllSums[0][0] = array[0];
		
		
		// from 1 to k + 1 partitions
		for(int partitions = 0; partitions <= k; partitions++){
			// partition can happen anywhere in array, in first element, or last element
			// which would imply taking all of the elements 
			for(int indexPartition = 0; indexPartition < array.length; indexPartition++){
				double firstPartition = 0.0;
				double secondPartition = 0.0;
				for(int indexFirstPartition = partitions; indexFirstPartition <= indexPartition; indexFirstPartition++){
					firstPartition += array[indexFirstPartition];
				}
				
				for(int indexSecondPartition = indexPartition + 1; indexSecondPartition < array.length; indexSecondPartition++){
					secondPartition += array[indexSecondPartition];
				}
				matrixWithAllSums[partitions][indexPartition] = Math.min(Math.abs(firstPartition - arrayOfAverages[partitions]), Math.abs(secondPartition - arrayOfAverages[partitions]));
			}
		}
		
		printMatrix(matrixWithAllSums);
		
		
		return minimumImbalance;
	}
	
	public void printMatrix(double[][] matrix){
		for(int row = 0; row < matrix.length; row++){
			for(int column = 0; column < matrix[row].length; column++){
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}

}
