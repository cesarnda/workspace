package edu.harvard/cscie124.problemset05;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaximumSubSequenceTestCase {

	
	@Test
	public void getMaximumSum_With_Only_Negative_Integers(){
		int[] array = new int[]{-1, -1, -3, -6, -10, -11};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(0.0, sum);
		assertEquals(-1, maximumSubSequenceDTO.getStartIndex());
		assertEquals(-1, maximumSubSequenceDTO.getEndIndex());
	}
	
	@Test
	public void getMaximumSum_With_Only_One_Integer(){
		int[] array = new int[]{-1, -1, -3, 6, -10, -11};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(6.0, sum);
		assertEquals(3, maximumSubSequenceDTO.getStartIndex());
		assertEquals(4, maximumSubSequenceDTO.getEndIndex());
	}
	
	@Test
	public void getMaximumSum_With_Maximum_Sum_Between_Negatives(){
		int[] array = new int[]{-1, -1, 3, 6, -1, -3, 11};
		MaximumSubSequence maximumSubSequence = new MaximumSubSequence();
		MaximumSubSequenceDTO maximumSubSequenceDTO = maximumSubSequence.getMaximumSum(array);
		double sum = maximumSubSequenceDTO.getMaximumSum();
		assertEquals(16.0, sum);
		assertEquals(2, maximumSubSequenceDTO.getStartIndex());
		assertEquals(6, maximumSubSequenceDTO.getEndIndex());
	}
