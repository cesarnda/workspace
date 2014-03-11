package edu.harvard.cscie124.problemset05;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaximumSubSequenceTestCase {

	private final double DELTA = 0.01;
	
	@Test
	public void getMaximumSum_With_Only_Negative_Integers(){
		int[] array = new int[]{-1, -1, -3, -6, -10, -11};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(0.0, sum, DELTA);
		assertEquals(-1, maximumSubSequenceDTO.getStartIndex());
		assertEquals(-1, maximumSubSequenceDTO.getEndIndex());
	}
	
	@Test
	public void getMaximumSum_With_Only_One_Integer(){
		int[] array = new int[]{-1, -1, -3, 6, -10, -11};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(6.0, sum, DELTA);
		assertEquals(3, maximumSubSequenceDTO.getStartIndex());
		assertEquals(3, maximumSubSequenceDTO.getEndIndex());
	}
	
	@Test
	public void getMaximumSum_With_Maximum_Sum_Between_Negatives(){
		int[] array = new int[]{-1, -1, 3, 6, -1, -3, 11};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(16.0, sum, DELTA);
		assertEquals(2, maximumSubSequenceDTO.getStartIndex());
		assertEquals(6, maximumSubSequenceDTO.getEndIndex());
	}
	
	@Test
	public void getMaximumSum_With_Maximum_Sum_Between_Negatives_And_Two_Positive_SubSequences(){
		int[] array = new int[]{-1, -1, 3, 6, -1, -3, 11, -16, -18, 20};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(20.0, sum, DELTA);
		assertEquals(9, maximumSubSequenceDTO.getStartIndex());
		assertEquals(9, maximumSubSequenceDTO.getEndIndex());
	}
	
	
}

