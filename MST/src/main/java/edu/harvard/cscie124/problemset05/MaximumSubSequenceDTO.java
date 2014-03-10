package edu.harvard.cscie124.problemset05;

public class MaximumSubSequenceDTO {
	
	private double maximumSum;
	private int startIndex;
	private int endIndex;
	
	public double getMaximumSum() {
		return maximumSum;
	}
	
	public void setMaximumSum(double maximumSum) {
		this.maximumSum = maximumSum;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getEndIndex() {
		return endIndex;
	}
	
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}
