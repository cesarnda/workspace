package edu.harvard.cscie124.pa3.heuristic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.harvard.cscie124.pa3.HeuristicSolver;
import edu.harvard.cscie124.pa3.NumberPartitionSolver;
import edu.harvard.cscie124.pa3.structure.Solution;

public class SimulatedAnnealing extends HeuristicSolver implements
		NumberPartitionSolver {

	@Override
	public long getResidue(List<Long> list) {
		Collections.sort(list);
		long residue = iterateToFindMinimum(list);
		return residue;
	}
	
	public long applySimulatedAnnealing(String filename) throws FileNotFoundException{
		List<Long> elements = readIntegersFromFile(filename);
		return getResidue(elements);
	}
	
	public long iterateToFindMinimum(List<Long> list){
		List<Long> a1 = new ArrayList<Long>();
		List<Long> a2 = new ArrayList<Long>();
		Long minimum = list.get(list.size() - 1);
		Long currentMinimum;
		int i; 
		int j;
		
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
		Solution SPrimePrime = S.clone();

		for(int iter = 0; iter < MAX_ITER; iter++){
			SPrime = S.clone();
			
			// find neighbor
			i = random.nextInt(a1.size());
			while((j = random.nextInt(a2.size())) == i);

			SPrime.swapElements(i, j);
			
			
			currentMinimum = SPrime.getResidue();
			if(currentMinimum < S.getResidue()){
				minimum = currentMinimum;
				if(minimum == 0){ // if we already find a residue 0, then we stop
					return 0;
				}
				S = SPrime.clone();
			}else{
				if(changeToSPrime(SPrime, S, iter) == true){
					S = SPrime.clone();
				}
			}
			currentMinimum = S.getResidue();
			if(currentMinimum < SPrimePrime.getResidue()){
				SPrimePrime = S.clone();
				if(currentMinimum < minimum){
					minimum = currentMinimum;
					if(minimum == 0){ // if we already find a residue 0, then we stop
						return 0;
					}
				}
			}
			
		}

		return minimum;
	}
	
	public boolean changeToSPrime(Solution S, Solution SPrime, int iter){
		Long base = SPrime.getResidue() - S.getResidue();
		Double power = - base / functionT(iter);
		double probability = Math.pow(Math.E, power);
		if(probability < 0.5){
			return false;
		}
		
		return true;
	}
	
	private double functionT(int iter){
		int power = (int)Math.floor(iter / 300);
		return 100000000000L *Math.pow(0.8, power);
	}

}
