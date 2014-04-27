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
		assertEquals(0, karmarkarKarp.getResidue(new ArrayList<Long>()));
	}
	
	@Test
	public void getResidue_Test_With_Only_One_Element(){
		final long SOLE_ELEMENT = 10L;
		final List<Long> elements = new ArrayList<Long>(1);
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
		final List<Long> elements = new ArrayList<Long>(5);
		elements.add(10L);
		elements.add(8L);
		elements.add(7L);
		elements.add(6L);
		elements.add(5L);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(2L, karmarkarKarp.getResidue(elements));
	}
	
	@Test
	public void getResidue_Test_With_Simple_Example_In_Reverse_Sorted_Order(){
		final List<Long> elements = new ArrayList<Long>(5);
		elements.add(5L);
		elements.add(6L);
		elements.add(7L);
		elements.add(8L);
		elements.add(10L);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(2, karmarkarKarp.getResidue(elements));
	}
	
	@Test
	public void getResidue_Test_With_Simple_Example_In_Random_Order(){
		final List<Long> elements = new ArrayList<Long>(5);
		elements.add(7L);
		elements.add(10L);
		elements.add(6L);
		elements.add(8L);
		elements.add(5L);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(2, karmarkarKarp.getResidue(elements));
	}
	
	
	@Test
	public void getResidue_Test_With_Residue_0_With_2_Elements(){
		final List<Long> elements = new ArrayList<Long>(2);
		elements.add(7L);
		elements.add(7L);
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(0, karmarkarKarp.getResidue(elements));
	}
	
	@Test
	public void getResidue_Test_With_Residue_0_By_Adding_The_Same_List(){
		final List<Long> elements = new ArrayList<Long>();
		elements.add(7L);
		elements.add(10L);
		elements.add(6L);
		elements.add(8L);
		elements.add(5L);
		elements.addAll(elements);
		
		KarmarkarKarp karmarkarKarp = new KarmarkarKarp();
		assertEquals(0, karmarkarKarp.getResidue(elements));
	}
}
