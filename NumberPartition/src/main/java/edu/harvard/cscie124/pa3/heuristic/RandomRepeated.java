package edu.harvard.cscie124.pa3.heuristic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.harvard.cscie124.pa3.HeuristicSolver;
import edu.harvard.cscie124.pa3.NumberPartitionSolver;

public class RandomRepeated extends HeuristicSolver implements NumberPartitionSolver {

	private Random random;
	
	public RandomRepeated(){
		random = new Random();
	}
	
	@Override
	public long getResidue(List<Long> list) {
		Collections.sort(list);
		long residue = iterateToFindMinimum(list);
		return residue;
	}
	
	public long applyRandomRepeated(String filename) throws FileNotFoundException{
		List<Long> elements = readIntegersFromFile(filename);
		return getResidue(elements);
	}
	
	public long iterateToFindMinimum(List<Long> list){
		List<Long> a1 = new ArrayList<Long>();
		List<Long> a2 = new ArrayList<Long>();
		Long minimum = list.get(list.size() - 1);
		Long currentMinimum;
		
		for(int iter = 0; iter < MAX_ITER; iter++){
			for(Long element : list){
				if(random.nextBoolean()){
					a1.add(element);
				}else{
					a2.add(element);
				}
			}
			Long s1 = getTotalSum(a1);
			Long s2 = getTotalSum(a2);
			currentMinimum = Math.abs(s1 - s2);
			if(currentMinimum < minimum){
				minimum = currentMinimum;
				if(minimum == 0){ // if we already find a residue 0, then we stop
					return 0;
				}
			}
			a1.clear();
			a2.clear();
		}
		
		return minimum;
	}

}
