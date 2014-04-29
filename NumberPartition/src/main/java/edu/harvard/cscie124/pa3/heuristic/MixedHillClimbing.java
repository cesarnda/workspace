package edu.harvard.cscie124.pa3.heuristic;

import java.util.List;

import edu.harvard.cscie124.pa3.MixedHeuristicSolver;

public class MixedHillClimbing extends MixedHeuristicSolver {

	@Override
	public Long iterateToFindMinimum(List<Long> list){
		Long minimum = list.get(list.size() - 1);
		Long currentMinimum;
		int[] S = getRandomPartition(list.size());
		int[] SPrime;
		for(int iter = 0; iter < MAX_ITER; iter++){
			SPrime = getRandomNeighborOfS(S);
			currentMinimum = getResidueFromKK(list, SPrime);
			if(currentMinimum < minimum){
				minimum = currentMinimum;
				if(minimum == 0){ // if we already find a residue 0, then we stop
					return 0L;
				}
				S = cloneArray(SPrime);
			}
		}
		
		return minimum;
	}
	
	public int[] getRandomNeighborOfS(int[] S){
		int[] SPrime = cloneArray(S);
		int i = random.nextInt(S.length);
		int j;
		while((j = random.nextInt(S.length)) == i);
		
		int temp = SPrime[i];
		SPrime[i] = SPrime[j];
		SPrime[j] = temp;
		return SPrime;
	}
	
	public int[] getRandomPartition(int size){
		int[] p = new int[size];
		for(int index = 0; index < size; index++){
			p[index] = random.nextInt(size);
		}
		return p;
	}

}
