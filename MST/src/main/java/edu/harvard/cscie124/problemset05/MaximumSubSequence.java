package edu.harvard.cscie124.problemset05;

public MaximumSubSequenceDTO getMaximumSum(int[] array){
		int maximumSum = 0;
		int proposedMaximumSum = 0;
		MaximumSubSequenceDTO maximumSubSequenceDTO = new MaximumSubSequenceDTO();
		maximumSubSequenceDTO.setStartIndex(-1);
		maximumSubSequenceDTO.setEndIndex(-1);
		int startIndex = 0;
		while(startIndex < array.length && array[startIndex] <= 0){
			startIndex++;
		}
		
		if(startIndex == array.length){
			return maximumSubSequenceDTO;
		}
		
		// start with the first positive number
		maximumSubSequenceDTO.setStartIndex(startIndex);
		
		for(int index = startIndex; index < array.length; index++){
			
			proposedMaximumSum += array[index];
			
			// if a new proposed maximum sum is found, then end the
			// corresponding sub sequence now
			if(proposedMaximumSum > maximumSum){
				maximumSum = proposedMaximumSum;
				maximumSubSequenceDTO.setEndIndex(index);
			}
			
			
			if(proposedMaximumSum + maximumSum == 0){
				proposedMaximumSum = 0;
				maximumSubSequenceDTO.setStartIndex(index);
			}
			
		}
		
		maximumSubSequenceDTO.setMaximumSum(maximumSum);
		
		return maximumSubSequenceDTO;
	}

}
