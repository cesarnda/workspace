package edu.harvard.cscie124.pa3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.harvard.cscie124.pa3.heuristic.KarmarkarKarp;

public abstract class MixedHeuristicSolver extends HeuristicSolver implements
		NumberPartitionSolver {

	private KarmarkarKarp kk;
	
	public MixedHeuristicSolver(){
		kk = new KarmarkarKarp();
	}
	
	
	@Override
	public long getResidue(List<Long> list) {
		Collections.sort(list);
		long residue = iterateToFindMinimum(list);
		return residue;
	}
	
	public abstract Long iterateToFindMinimum(List<Long> list);

	
	public Long getResidueFromKK(List<Long> list, int[] partition){
		return kk.getResidue(getAPrime(list, partition));
	}
	
	public List<Long> getAPrime(List<Long> list, int[] p){
		int limit = p.length;
		long[] aPrime = new long[limit];
		for(int j = 0; j < limit; j++){
			aPrime[p[j]] += list.get(j);
		}
		List<Long> listAPrime = new ArrayList<Long>();
		for(long element : aPrime){
			if(element > 0){
				listAPrime.add(element);
			}
		}
		
		return listAPrime;
	}
}
