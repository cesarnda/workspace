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
	
	public static void main(String ... args){
		String binaryNumber = "010001110110100101110110011001010010000001101101011001010010000001100001011011100010000001000001";
		System.out.println("Length of the binary number: " + binaryNumber.length());
		BigInteger bigMessage = new BigInteger(binaryNumber, 2);
		System.out.println("Numeric value: " + bigMessage);
		
		BigInteger bigN = new BigInteger("46947848749720430529628739081");
		BigInteger bigE = new BigInteger("37267486263679235062064536973");
		int comparison = bigMessage.compareTo(bigN);
		System.out.println("Comparing big message against n is: " + comparison);
		BigInteger result = bigMessage.modPow(bigE, bigN);
		System.out.println("message to e mod n is: " + result);
	}
	
	
	public int findWitness(int possiblePrime){
		logger.info("Trying to determine if " + possiblePrime + " is prime.");
		int possibleWitness = 1;
		int reminder = 1;
		do{
			possibleWitness = random.nextInt(possiblePrime);
			logger.debug("Trying with " + possibleWitness);
			
			if(greatedCommonDivisor(possibleWitness, possiblePrime) == 1){
				continue; // Ignore Carmichael numbers
			}
			
			reminder = applyFermatLittleTheorem(possibleWitness, possiblePrime - 1, possiblePrime);
		}while(reminder == 1);
		
		logger.info("The witness " + possibleWitness + " returned the reminder " + reminder);
		
		return possibleWitness;
	}
	
	public int greatedCommonDivisor(int a, int b) { 
		return b == 0 ? a : greatedCommonDivisor(b, a % b); 
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
