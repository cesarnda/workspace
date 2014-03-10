package edu.harvard.cscie124.problemset05;

public class MaximumSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getMaximumSum(int[] array){
		int maximumSum = 0;
		int proposedMaximumSum = 0;
		
		int startIndex = 0;
		while(startIndex < array.length && array[startIndex] <= 0){
			startIndex++;
		}
		
		if(startIndex == array.length){
			return 0;
		}
		
		for(int index = startIndex; index < array.length; index++){
			
			proposedMaximumSum += array[index];
			
			if(proposedMaximumSum > maximumSum){
				maximumSum = proposedMaximumSum;
			}
			
			if(proposedMaximumSum + maximumSum == 0){
				proposedMaximumSum = 0;
			}
			
		}
		return maximumSum;
	}

}
