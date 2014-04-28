package edu.harvard.cscie124.pa3;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrix {

	private Map<Long, Boolean>[] sparseMatrix;
	private Map<Long, Boolean> indicatorMap;
	
	@SuppressWarnings("unchecked")
	public SparseMatrix(int numberOfRows){
		sparseMatrix = new Map[numberOfRows];
		indicatorMap = new HashMap<Long, Boolean>();
	}
	
	public void assignTrue(int i, Long value){
		if(sparseMatrix[i] == null){
			sparseMatrix[i] = new HashMap<Long, Boolean>();
		}
		sparseMatrix[i].put(value, true);
		indicatorMap.put(value, true);
	}
	
	public boolean isSumPossible(Long value){
		if(indicatorMap.get(value) == null){
			return false;
		}
		return indicatorMap.get(value);
	}
	
	public boolean getAssignation(int i, Long value){
		if(sparseMatrix[i] == null){
			return false;
		}
		if(sparseMatrix[i].get(value) == null){
			return false;
		}
		return true;
	}
}
