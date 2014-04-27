package edu.harvard.cscie124.pa3;

import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsInFileGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(ElementsInFileGenerator.class);

	private static final int MAX_NUMBER_OF_DIGITS = 14;
	private static final int MAX_NUMBER_OF_ELEMENTS = 100;
	private static final String FILE_NAME_PREFIX = "src/test/resources/RandomInstance-";
	private static final int NUMBER_OF_PROBLEM_INSTANCES = 50;
	
	private Random random;

	public ElementsInFileGenerator(){
		random = new Random();
	}
	
	public static void main(String ... args){
		ElementsInFileGenerator elementsInFileGenerator = new ElementsInFileGenerator();
		elementsInFileGenerator.generateRandomInstances();
	}
	
	public void generateOneSample(){
		generateFileWithRandomIntegers(FILE_NAME_PREFIX + 0 + ".txt");
	}
	
	public void generateRandomInstances(){
		for(int index = 1; index <= NUMBER_OF_PROBLEM_INSTANCES; index++){
			generateFileWithRandomIntegers(FILE_NAME_PREFIX + (index < 10 ? "0" : "") + index + ".txt");
		}
	}
	
	public void generateFileWithRandomIntegers(String filename){
		List<Long> elements = getRandomElements();
		FileWriter fileWriter = null;
		int limit = elements.size() - 1;
		try{
			fileWriter = new FileWriter(filename);
			for(int index = 0; index < limit; index++){
				fileWriter.write(elements.get(index) + "\n");
			}
			fileWriter.write(elements.get(elements.size() - 1) + "");
		}catch(Exception e){
			logger.error("Exception while trying to open and write on: " + filename);
		}
		finally{
			if(fileWriter != null){
				try{
					fileWriter.close();
				}catch(Exception e){
					logger.error("Unable to close the file: " + filename);
				}
			}
		}
	}

	public List<Long> getRandomElements(){
		byte[] numberInBytes = new byte[MAX_NUMBER_OF_DIGITS];

		Set<Long> elements = new HashSet<Long>();
		while(elements.size() < MAX_NUMBER_OF_ELEMENTS){
			random.nextBytes(numberInBytes);
			BigInteger element = new BigInteger(40, new Random());	
			if(element.longValue() < 1000000000001L){
				elements.add(element.longValue());
			}
		}
		
		return new ArrayList<Long>(elements);
	}

}
