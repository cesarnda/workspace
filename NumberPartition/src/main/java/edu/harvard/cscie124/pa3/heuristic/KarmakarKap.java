package edu.harvard.cscie124.pa3.heuristic;

import java.util.List;

import edu.harvard.cscie124.pa3.NumberPartitionSolver;

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
public class KarmakarKap implements NumberPartitionSolver {

	@Override
	public int getResidue(List<Integer> list) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int findResidueInSortedList(List<Integer> list){
		if(list.size() == 1){
			return list.get(0);
		}
		return 0;
	}

}
