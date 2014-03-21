package edu.harvard.cscie124.problemset06;

import java.math.BigInteger;
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
		int reminder = applyFermatLittleTheorem(base, modulus - 1,modulus);
		logger.info("The reminder of " + base + "^" + (modulus -1) + " modulus " + modulus + " is " + reminder);
		return reminder;
	}
	
	
	private int applyFermatLittleTheorem(Integer base, int exponent, Integer modulus){
		BigInteger bigBase = new BigInteger(base.toString());
		BigInteger bigModulus = new BigInteger(modulus.toString());
		BigInteger baseToExponent = bigBase.pow(exponent);
		BigInteger bigReminder = baseToExponent.mod(bigModulus);
		return bigReminder.intValue();
	}
	
}
