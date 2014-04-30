package edu.harvard.cscie124.pa3;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.cscie124.pa3.heuristic.NumberPartitionSolution;

public class AbstractTestCases {

	private static final Logger logger = LoggerFactory.getLogger(AbstractTestCases.class);
	private static final List<NumberPartitionSolution>[] allSolutions;
	private static int index = 0;

	static{
		allSolutions = new List[7];
	}

	public void printSolutions(List<NumberPartitionSolution> solutions){
		allSolutions[index++] = solutions;
		for(NumberPartitionSolution solution : solutions){
			logger.info("The method " + solution.getMethodUsed() + " took " + solution.getTimeTaken() + " milliseconds for file " + 
					solution.getFilename() + " and computed the residue " + 
					solution.getResidue());
		}
	}

	public void printSolutionsForLatex(){
		printSolutions1_x_y(1, 2);
		printSolutions1_x_y(3, 4);
		printSolutions1_x_y(5, 6);
	}
	
	private void printSolutions1_x_y(int s1, int s2){
		int[] s = new int[]{0, s1, s2};
		System.out.println("\\begin{longtable}{|c|cc|cc|cc|cc|cc|cc|cc|}");
		System.out.println("\\caption{Comparing results with KK,  Heuristics}\\\\");
		System.out.println("\\hline");
		System.out.print(" ");
		for(int index = 0; index < 3; index++){
			NumberPartitionSolution solution = allSolutions[s[index]].get(0);
			System.out.print("\t & \\multicolumn{2}{c}{ " + solution.getMethodUsed()  + "} ");
		}
		System.out.println("\\\\");
		System.out.println("\\hline");
		System.out.print("File");
		
		for(int index = 0; index < 3; index++){
			System.out.print("\t & Residue \t & \t Milliseconds");
		}
		System.out.println("\\\\");
		System.out.println("\\hline");
		
		for(int file = 1; file <= 50; file++){
			System.out.print(file);
			for(int index = 0; index < 3; index++){
				NumberPartitionSolution solution = allSolutions[s[index]].get(file - 1);
				System.out.print("\t &" + solution.getResidue() + "\t & \t" + solution.getTimeTaken());
			}
			System.out.println("\\\\");
		}
		System.out.println("\\hline");
		System.out.println("\\end{longtable}");
	}
}
