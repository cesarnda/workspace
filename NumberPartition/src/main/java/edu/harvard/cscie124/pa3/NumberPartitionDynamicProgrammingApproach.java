package edu.harvard.cscie124.pa3;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberPartitionDynamicProgrammingApproach implements NumberPartitionSolver {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberPartitionDynamicProgrammingApproach.class);

	
	private SparseMatrix sparseMatrix;
	
	

	@Override
	public long getResidue(List<Long> list) {
		sparseMatrix = new SparseMatrix(list.size());
		Collections.sort(list);
		logger.info("Finished sorting elements");
		Long totalSum = populateTableuToCheckIfASumIsPossible(list);
		logger.info("Finish populating the tableu");
		Long residue = findSumThatMinimizes(totalSum);
		if(residue != null){
			return 2 * residue + totalSum % 2;
		}
		
		return totalSum;
	}
	
	public Long populateTableuToCheckIfASumIsPossible(List<Long> sortedList){
		Long totalSum = getTotalSum(sortedList);
		int numberOfElements = sortedList.size();
		Long minimumElement = sortedList.get(0);
		sparseMatrix.assignTrue(0, minimumElement); // initialize tableu
		
		for(int indexRow = 1; indexRow < numberOfElements; indexRow++){
			for(long indexColumn = minimumElement; indexColumn <= totalSum; indexColumn++){
				if(	sparseMatrix.getAssignation(indexRow - 1, indexColumn) || 
					sparseMatrix.getAssignation(indexRow - 1, indexColumn - sortedList.get(indexRow))){
					sparseMatrix.assignTrue(indexRow, indexColumn);
				}
			}
		}
		return totalSum;
	}
	
	public Long findSumThatMinimizes(Long totalSum){
		Long halfSum = totalSum / 2;
		for(long indexValues = halfSum; indexValues > 0; indexValues--){
			if(sparseMatrix.isSumPossible(indexValues)){
				return Math.abs(halfSum - indexValues);
			}
		}
		return null;
	}

	public void removeElementsGreaterThanHalf(List<Long> sortedList, Long totalSum){
		Long halfSum = totalSum / 2 + 1;
		int indexOfElements = sortedList.size() - 1;
		while(sortedList.get(indexOfElements) > halfSum){
			sortedList.remove(indexOfElements);
		}
	}
	
	public Long getTotalSum(List<Long> list){
		Long totalSum = 0L;
		for(Long element : list){
			totalSum += element;
		}
		return totalSum;
	}

}
