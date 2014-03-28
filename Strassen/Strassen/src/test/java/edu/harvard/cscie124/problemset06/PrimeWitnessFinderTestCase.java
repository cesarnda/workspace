package edu.harvard.cscie124.problemset06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import edu.harvard.cscie124.problemset06.PrimeWitnessFinder;

public class PrimeWitnessFinderTestCase {
	
	@Test
	public void findWitness_Test_With_636_127(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int witness = primeWitnessFinder.findWitness(636_127);
		assertNotEquals(1, witness);
	}
	
	@Test
	public void findWitness_Test_With_294_409(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int witness = primeWitnessFinder.findWitness(294_409);
		assertNotEquals(1, witness);
	}
	/*
	@Test
	public void applyFermatLittleTheorem_Test_With_a_2_And_p_7(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(2, 7);
		assertEquals(1, reminder);
	}
	
	@Test
	public void applyFermatLittleTheorem_Test_With_a_3_And_p_2(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(3, 2);
		assertEquals(1, reminder);
	}
	
	@Test
	public void applyFermatLittleTheorem_Test_With_a_6_And_p_2(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(6, 2);
		assertEquals(0, reminder);
	}
	
	@Test
	public void applyFermatLittleTheorem_Test_With_a_14_And_p_7(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(-14, 7);
		assertEquals(0, reminder);
	}

	@Test
	public void applyFermatLittleTheorem_Test_With_a_150_And_p_997(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(150,997);
		assertEquals(1, reminder);
	}
	
	@Test
	public void test_11_Is_Prime(){
		applyFermatLittleTheorem_Test_P_Is_Prime(11);
	}
	
	
	@Test
	public void test_Pseudo_Prime(){
		int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
									53, 59, 61, 67, 71, 73, 79, 83, 997};
		for(int prime : primes){
			applyFermatLittleTheorem_Test_P_Is_Prime(prime);
		}
	}
	*/
	
	public void applyFermatLittleTheorem_Test_P_Is_Prime(int p){
		for(int a = 1; a < p; a++){
			applyFermatLittleTheorem_Test_P_Is_Prime_With_Base_a(a, p);
		}
	}
	
	public void applyFermatLittleTheorem_Test_P_Is_Prime_With_Base_a(int a, int p){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(a, p);
		assertEquals(1, reminder);
	}
}
