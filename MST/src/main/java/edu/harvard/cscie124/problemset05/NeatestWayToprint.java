package edu.harvard.cscie124.problemset05;

import java.util.ArrayList;
import java.util.List;

public class NeatestWayToprint {

	private static final String BUFFY = "Buffy the Vampire Slayer fans are sure to get their fix with the DVD release of the show's first season. " + 
										"The three-disc collection includes all 12 episodes as well as many extras. There is a collection of interviews " +
										"by the show's creator Joss Whedon in which he explains his inspiration for the show as well as comments on " +
										"the various cast members. Much of the same material is covered in more depth with Wheadon's commentary track " +
										"for the show's first two episodes that make up the Buffy The Vampire Slayer pilot. The most interesting points " +
										"of Whedon's commentary come from his explanation of the learning curve he encountered shifting from blockbuster " +
										"films like Toy Story to a much lower-budget television series. The first disc also includes a short interview " +
										"with David Boreanaz who plays the role of Angel. Other features include the script for the pilot episodes, a " +
										"trailer, a large photo gallery of publicity shots and in-depth biographies of Whedon and several of the show's " +
										"stars, including Sarah Michelle Geller, Alyson Hannigan and Nicholas Brendon.";
	
	public static void main(String[] args) {
		NeatestWayToprint print = new NeatestWayToprint();
		print.neatPrint(BUFFY, 40);
		print.neatPrint(BUFFY, 72);
	}
	
	public void neatPrint(String words, int maximumLineLength){
		String[] wordsSplitted = words.split(" ");
		List<String> wordsList = new ArrayList<String>();
		for(String word : wordsSplitted){
			wordsList.add(word);
		}
		NeatPrinter neatPrinter =  getNeatPrinter(wordsList, maximumLineLength);
		int[] cutsInOrder = neatPrinter.getCuts();
		System.out.print("Cuts: " );
		printArray(cutsInOrder);
		int counter = 0;
		int cutsIndex = 0;
		System.out.println("Original String: ");
		System.out.println(words);
		for(String word : wordsSplitted){
			System.out.print(word);
			if(counter + 1 == wordsList.size()){
				if(counter == cutsInOrder[counter]){
					System.out.println();
				}
			}else if(cutsInOrder[counter] != cutsInOrder[counter + 1]){
				System.out.println();
			}else{
				System.out.print(" ");
			}
			counter++;
		}
	}
	
	
	public int[] getCutsInOrder(NeatPrinter neatPrinter){
		int[] cuts = neatPrinter.getCuts();
		int[] cutsInOrder = new int[cuts.length];
		System.out.print("Cuts: " );
		printArray(cuts);
		int previous = cuts[cuts.length - 1];
		for(int index = cuts.length - 1; index >= 0; index--){
			cutsInOrder[index] = cuts[previous];
			previous = cutsInOrder[index];
		}
		System.out.print("Cuts in order: " );
		printArray(cutsInOrder);
		return cutsInOrder;
	}
	
	private void printArray(int[] array){
		for(int element : array){
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	
	public NeatPrinter getNeatPrinter(List<String> words, int maximumLineLength){
		int[][] partialPenalties = getPartialPenaltiesPerLine(getExtraSpacesForEachCombination(words, maximumLineLength), maximumLineLength);
		return getAllOptimalCosts(partialPenalties);
	}
	
	public int[][] getExtraSpacesForEachCombination(List<String> words, int maximumLineLength){
		int numberOfWords = words.size();
		int[][] extraSpaces = new int[numberOfWords][numberOfWords];
		
		for(int rows = 0; rows < numberOfWords; rows++){
			initializeWithNegativeArray(extraSpaces[rows]);
			for(int columns = rows; columns < numberOfWords; columns++){
				extraSpaces[rows][columns] = maximumLineLength - columns + rows - getLenghtOfWords(words, rows, columns);
			}
		}
		
		return extraSpaces;
	}
	
	private void printBiArray(int[][] array){
		for(int rows = 0; rows < array.length; rows++){
			for(int columns = 0; columns < array.length; columns++){
				System.out.print(array[rows][columns] + " ");
			}
			System.out.println();
		}
	}
	
	public int getLenghtOfWords(List<String> words, int i, int j){
		int sumOfLengthOfWords = 0;
		for(String word : words.subList(i, j + 1)){
			sumOfLengthOfWords += word.length();
		}
		return sumOfLengthOfWords;
	}
	
	public int[][] getPartialPenaltiesPerLine(int[][] extraSpace, int maximumLineLength){
		System.out.println("\n\nExtra spaces cost: ");
		printBiArray(extraSpace);
		int numberOfWords = extraSpace.length;
		int[][] partialPenalties = new int[numberOfWords][numberOfWords];
		
		
		for(int rows = 0; rows < numberOfWords; rows++){
			initializeWithPositiveArray(partialPenalties[rows]);
			for(int columns = rows; columns < numberOfWords; columns++){
				if(columns == numberOfWords - 1 && extraSpace[rows][columns] > 0){
					// last line cost 0 only if if the words fit
					partialPenalties[rows][columns]  = 0;
				}
				else if(extraSpace[rows][columns] < 0){
					partialPenalties[rows][columns] = Short.MAX_VALUE;
				}else{
					partialPenalties[rows][columns] = extraSpace[rows][columns] * extraSpace[rows][columns] * extraSpace[rows][columns]; 
				}
			}
		}
		
		System.out.println("\n\n Partial penalties: ");
		printBiArray(partialPenalties);
		
		return partialPenalties;
	}
	
	private void initializeWithNegativeArray(int[] array){
		for(int index = 0; index < array.length; index++){
			array[index] = Short.MIN_VALUE;
		}
	}
	
	private void initializeWithPositiveArray(int[] array){
		for(int index = 0; index < array.length; index++){
			array[index] = Short.MAX_VALUE;
		}
	}
	
	public NeatPrinter getAllOptimalCosts(int[][] partialPenalties){
		int[] allOptimalCosts = new int[partialPenalties.length];
		allOptimalCosts[0] = 0;
		int[] lineCuts = new int[partialPenalties.length];
		for(int index = 0; index < partialPenalties.length; index++){
			allOptimalCosts[index] = getOptimalCost(allOptimalCosts, partialPenalties, lineCuts, index);
		}
		
		NeatPrinter neatPrinter = new NeatPrinter();
		System.out.print("Optimal costs: ");
		printArray(allOptimalCosts);
		neatPrinter.setCost(allOptimalCosts);
		neatPrinter.setCuts(lineCuts);
		return neatPrinter;
	}
	
	public int getOptimalCost(int[] optimalCost, int[][] partialPenalties, int[] lineCuts, int j){
		int minimumCost = Short.MAX_VALUE;
		for(int index = 0; index <= j; index++){
			int cost = (index == 0 ? 0 : optimalCost[index - 1]) + partialPenalties[index][j];
			if(cost < minimumCost){
				System.out.println("Cost reduce to be: "+ cost);
				minimumCost = cost;
				lineCuts[j] = index;
			}
		}
		return minimumCost;
	}

}
