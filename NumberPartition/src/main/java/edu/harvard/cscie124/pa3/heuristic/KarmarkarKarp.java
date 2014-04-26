package edu.harvard.cscie124.pa3.heuristic;

import java.util.List;

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

	
	public KarmarkarKarp(){
	}
	
	@Override
	public int getResidue(List<Integer> list) {
		
		if(list == null || list.isEmpty()){
			return 0;
		}
		
		Heap<Integer> heap = new MaxHeap<Integer>(list);
		return findResidueInSortedList(heap);
	}
	
	private int findResidueInSortedList(final Heap<Integer> heap){
		if(heap.size() == 0){
			return 0;
		}
		
		if(heap.size() == 1){
			return heap.deleteElementAtTop();
		}
		
		Integer firstlargest = heap.deleteElementAtTop();
		Integer secondLarget = heap.deleteElementAtTop();
		Integer residue = Math.abs(firstlargest - secondLarget);
		// Only nonzero elements are inserted, otherwise, they will not affect the final result
		if(residue > 0){
			heap.insertElement(residue);
		}
		
		return findResidueInSortedList(heap);
	}

}
