package edu.harvard.cscie124.problemset06;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class PrimeWitnessFinderTestCase {
	
	@Test
	public void findWitness_Test_With_636_127(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int witness = primeWitnessFinder.findWitness(636_127);
		assertNotEquals(1, witness);
	}
	
	@Test
	public void findWitness_Test_With_a_2_And_p_7(){
		PrimeWitnessFinder primeWitnessFinder = new PrimeWitnessFinder();
		int reminder = primeWitnessFinder.applyFermatLittleTheorem(2, 7);
		assertEquals(1, reminder);
	}
}
