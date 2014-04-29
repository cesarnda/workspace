package edu.harvard.cscie124.pa3.heuristic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.harvard.cscie124.pa3.HeuristicSolver;
import edu.harvard.cscie124.pa3.NumberPartitionSolver;
import edu.harvard.cscie124.pa3.structure.Solution;

public class HillClimbing extends HeuristicSolver implements NumberPartitionSolver {

	@Override
	public long getResidue(List<Long> list) {
		Collections.sort(list);
		long residue = iterateToFindMinimum(list);
		return residue;
	}

	public long applyHillClimbing(String filename) throws FileNotFoundException{
		List<Long> elements = readIntegersFromFile(filename);
		return getResidue(elements);
	}

	public long iterateToFindMinimum(List<Long> list){
		List<Long> a1 = new ArrayList<Long>();
		List<Long> a2 = new ArrayList<Long>();
		int i; 
		int j;
		Long sPrimeResidue;
		
		// initial random solution
		for(Long element : list){
			if(random.nextBoolean()){
				a1.add(element);
			}else{
				a2.add(element);
			}
		}

		Solution S = new Solution();
		S.assignCopyToA1(a1);
		S.assignCopyToA2(a2);
		
		Solution SPrime;
		Long minimum = S.getResidue();
		for(int iter = 0; iter < MAX_ITER; iter++){
			SPrime = S.clone();
			
			// find neighbor
			i = random.nextInt(a1.size());
			while((j = random.nextInt(a2.size())) == i);

			SPrime.swapElements(i, j);
			
			
			sPrimeResidue = SPrime.getResidue();		
			if(sPrimeResidue < S.getResidue()){
				minimum = sPrimeResidue;
				if(minimum == 0){ // if we already find a residue 0, then we stop
					return 0;
				}
				S = SPrime.clone();
			}
			
		}

		return minimum;
	} 

}
