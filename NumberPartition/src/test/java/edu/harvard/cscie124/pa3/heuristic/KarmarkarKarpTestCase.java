package edu.harvard.cscie124.pa3.heuristic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KarmarkarKarpTestCase {

	@Test
	public void getResidue_Test_With_Null_List(){
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(0, karmarkarKarp.getResidue(null));
	}
	
	@Test
	public void getResidue_Test_With_Empty_List(){
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(0, karmarkarKarp.getResidue(new ArrayList<Integer>()));
	}
	
	@Test
	public void getResidue_Test_With_Only_One_Element(){
		final int SOLE_ELEMENT = 10;
		final List<Integer> elements = new ArrayList<Integer>(1);
		elements.add(SOLE_ELEMENT);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(SOLE_ELEMENT, karmarkarKarp.getResidue(elements));
	}
	
	/**
	 * (10, 8, 7, 6, 5) -> (2, 0, 7, 6, 5)
	 * 					-> (2, 0, 1, 0, 5)
	 * 					-> (0, 0, 1, 0, 3)
	 * 					-> (0, 0, 0, 0, 2)	
	 */
	@Test
	public void getResidue_Test_With_Simple_Example(){
		final List<Integer> elements = new ArrayList<Integer>(1);
		elements.add(10);
		elements.add(8);
		elements.add(7);
		elements.add(6);
		elements.add(5);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(2, karmarkarKarp.getResidue(elements));
	}
	
	@Test
	public void getResidue_Test_With_Simple_Example_In_Reverse_Sorted_Order(){
		final List<Integer> elements = new ArrayList<Integer>(1);
		elements.add(5);
		elements.add(6);
		elements.add(7);
		elements.add(8);
		elements.add(10);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(2, karmarkarKarp.getResidue(elements));
	}
	
	@Test
	public void getResidue_Test_With_Simple_Example_In_Random_Order(){
		final List<Integer> elements = new ArrayList<Integer>(1);
		elements.add(7);
		elements.add(10);
		elements.add(6);
		elements.add(8);
		elements.add(5);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(2, karmarkarKarp.getResidue(elements));
	}
	
	
	@Test
	public void getResidue_Test_With_Residue_With_2_Elements(){
		final List<Integer> elements = new ArrayList<Integer>(2);
		elements.add(7);
		elements.add(7);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(0, karmarkarKarp.getResidue(elements));
	}
}
