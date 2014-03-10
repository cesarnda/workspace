package edu.harvard.cscie124.problemset05;

public class MaximumSubSequenceDTO {
	
	private Double maximumSum;
	private int startIndex;
	private int endIndex;
	
	public Double getMaximumSum() {
		return maximumSum;
	}
	
	public void setMaximumSum(Double maximumSum) {
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
