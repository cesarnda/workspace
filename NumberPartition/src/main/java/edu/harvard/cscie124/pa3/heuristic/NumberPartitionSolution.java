package edu.harvard.cscie124.pa3.heuristic;

public class NumberPartitionSolution implements Comparable<NumberPartitionSolution> {

	private Long timeTaken;
	private String methodUsed;
	private Long residue;
	private String filename;
	
	public NumberPartitionSolution(Long timeTaken, String filename, Long residue, String methodUsed) {
		super();
		this.filename = filename;
		this.timeTaken = timeTaken;
		this.methodUsed = methodUsed;
		this.residue = residue;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getTimeTaken() {
		return timeTaken;
	}
	
	public void setTimeTaken(Long timeTaken) {
		this.timeTaken = timeTaken;
	}
	
	public String getMethodUsed() {
		return methodUsed;
	}
	
	public void setMethodUsed(String methodUsed) {
		this.methodUsed = methodUsed;
	}
	
	public Long getResidue() {
		return residue;
	}
	
	public void setResidue(Long residue) {
		this.residue = residue;
	}
	
	/**
	 * The results are sorted by residue and time taken
	 */
	@Override
	public int compareTo(NumberPartitionSolution other) {
		long difference = this.residue - other.getResidue();
		if(difference < 0){
			return -1;
		}
		if(difference > 0){
			return 1;
		}
		
		difference = this.timeTaken - other.getTimeTaken();
		
		if(difference < 0){
			return -1;
		}
		if(difference > 0){
			return 1;
		}
		
		return 0;
	}
}
