package edu.harvard.cscie124.pa3.heuristic;

import java.util.List;

import edu.harvard.cscie124.pa3.MixedHeuristicSolver;

public class MixedRandomRepeated extends MixedHeuristicSolver {
	
	@Override
	public Long iterateToFindMinimum(List<Long> list){
		Long minimum = list.get(list.size() - 1);
		Long currentMinimum;
		for(int iter = 0; iter < MAX_ITER; iter++){
			
			currentMinimum = getResidueFromKK(list, getRandomPartition(list.size()));
			if(currentMinimum < minimum){
				minimum = currentMinimum;
				if(minimum == 0){ // if we already find a residue 0, then we stop
					return 0L;
				}
			}
		}
		
		return minimum;
	}
	
	public int[] getRandomPartition(int size){
		int[] p = new int[size];
		for(int index = 0; index < size; index++){
			p[index] = random.nextInt(size);
		}
		return p;
	}

}
