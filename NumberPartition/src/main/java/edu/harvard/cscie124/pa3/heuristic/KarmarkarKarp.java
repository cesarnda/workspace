package edu.harvard.cscie124.pa3.heuristic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.cscie124.pa3.NumberPartitionSolver;
import edu.harvard.cscie124.pa3.structure.Heap;
import edu.harvard.cscie124.pa3.structure.MaxHeap;

/**
 * For the Karmarkar-Kap algorithms suggests repeatedly taking
 * the largest two elements remaining in A at each step and 
 * differencing them. For example, if A is initially (10, 8, 7, 5),
 * then the KK algorithm proceeds as follows:
 * 
 * (10, 8, 7, 6, 5) -> (2, 0, 7, 6, 5)
 * 					-> (2, 0, 1, 0, 5)
 * 					-> (0, 0, 1, 0, 3)
 * 					-> (0, 0, 0, 0, 2)	
 * 
 * @author cesarnda
 *
 */
public class KarmarkarKarp implements NumberPartitionSolver {

	private static final Logger logger = LoggerFactory.getLogger(KarmarkarKarp.class);

	
	public KarmarkarKarp(){
	}
	
	@Override
	public long getResidue(List<Long> list) {
		
		if(list == null || list.isEmpty()){
			return 0;
		}
		
		Heap<Long> heap = new MaxHeap<Long>(list);
		return findResidueInSortedList(heap);
	}
	
	private long findResidueInSortedList(final Heap<Long> heap){
		if(heap.size() == 0){
			return 0;
		}
		
		if(heap.size() == 1){
			return heap.deleteElementAtTop();
		}
		
		Long firstlargest = heap.deleteElementAtTop();
		Long secondLarget = heap.deleteElementAtTop();
		Long residue = Math.abs(firstlargest - secondLarget);
		// Only nonzero elements are inserted, otherwise, they will not affect the final result
		if(residue > 0){
			heap.insertElement(residue);
		}
		
		return findResidueInSortedList(heap);
	}

}
