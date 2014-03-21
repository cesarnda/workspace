package edu.harvard.cscie124.problemset06;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimeWitnessFinder {

	private static final Logger logger = LoggerFactory.getLogger(PrimeWitnessFinder.class);

	
	private Random random;
	
	public PrimeWitnessFinder(){
		random = new Random();
	}
	
	
	public int findWitness(int possiblePrime){
		logger.info("Trying to determine if " + possiblePrime + " is prime.");
		int possibleWitness = 1;
		int reminder = 1;
		do{
			possibleWitness = random.nextInt(possiblePrime);
			logger.debug("Trying with " + possibleWitness);
			reminder = applyFermatLittleTheorem(possibleWitness, possiblePrime - 1, possiblePrime);
		}while(reminder == 1);
		
		logger.info("The witness " + possibleWitness + " returned the reminder " + reminder);
		
		return possibleWitness;
	}
	
	public int applyFermatLittleTheorem(int base, int modulus){
		return applyFermatLittleTheorem(base, modulus - 1,modulus);
	}
	
	
	private int applyFermatLittleTheorem(int base, int power, int modulus){
		if(power == 1){
			return base % modulus;
		}
		if(power % 2 == 0){
			int poweredA = applyFermatLittleTheorem(base, power / 2, modulus);
			return (poweredA * poweredA) % modulus;
		}
		int newPower = (int)Math.floor(power / 2);
		int poweredBase = applyFermatLittleTheorem(base, newPower, modulus);
		return (((poweredBase * poweredBase) % modulus) * poweredBase ) % modulus;
	}
	
}
