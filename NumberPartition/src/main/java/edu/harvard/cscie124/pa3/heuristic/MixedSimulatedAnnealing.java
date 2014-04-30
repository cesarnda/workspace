package edu.harvard.cscie124.pa3.heuristic;

import java.util.List;

import edu.harvard.cscie124.pa3.MixedHeuristicSolver;

public class MixedSimulatedAnnealing extends MixedHeuristicSolver {

	@Override
	public Long iterateToFindMinimum(List<Long> list) {
		Long minimum = list.get(list.size() - 1);
		int[] S = getRandomPartition(list.size());
		int[] SPrime;
		int[] SPrimePrime = cloneArray(S);
		Long residueOfS;
		Long residueOfSPP;
		Long residueOfSP;
		for(int iter = 0; iter < MAX_ITER; iter++){
			SPrime = getRandomNeighborOfS(S);
			residueOfSP = getResidueFromKK(list, SPrime);
			residueOfS = getResidueFromKK(list, S);
			if(residueOfSP < residueOfS){
				if(residueOfSP < minimum){
					minimum = residueOfSP;
					if(minimum == 0){ // if we already find a residue 0, then we stop
						return 0L;
					}
				}
				
				S = cloneArray(SPrime);
			}else{
				if(changeToSPrime(residueOfS, residueOfS, iter)){
					S = cloneArray(SPrime);
				}
			}
			residueOfS = getResidueFromKK(list, S);
			residueOfSPP = getResidueFromKK(list, SPrimePrime);
			if(residueOfS < residueOfSPP){
				SPrimePrime = cloneArray(S);
				if(residueOfS < minimum){
					minimum = residueOfS;
					if(minimum == 0){ // if we already find a residue 0, then we stop
						return 0L;
					}
				}
			}
		}
		
		return minimum;
	}
	
	public int[] getRandomNeighborOfS(int[] S){
		int[] SPrime = cloneArray(S);
		int i = random.nextInt(S.length);
		int j;
		while((j = random.nextInt(S.length)) == S[i]);
		
		SPrime[i] = j;
		return SPrime;
	}
	
	public boolean changeToSPrime(Long residueOfS, Long residueOfSP, int iter){
		Long base = residueOfSP - residueOfS;
		Double power = - base / functionT(iter);
		double probability = Math.pow(Math.E, power);
		if(probability < 0.5){
			return false;
		}
		
		return true;
	}
	
	public int[] getRandomPartition(int size){
		int[] p = new int[size];
		for(int index = 0; index < size; index++){
			p[index] = random.nextInt(size);
		}
		return p;
	}
	
	private double functionT(int iter){
		int power = (int)Math.floor(iter / 300);
		return 100000000000L *Math.pow(0.8, power);
	}

}
