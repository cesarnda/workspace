package edu.harvard.cscie124.pa3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberPartitionDynamicProgrammingApproachTestCases {

	
	@Test
	public void getResidue_Test_With_One_Element(){
		List<Long> elements = new ArrayList<Long>();
		elements.add(12345L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(12345L, residue);
	}
	
	@Test
	public void getResidue_Test_With_Two_Element(){
		List<Long> elements = new ArrayList<Long>();
		elements.add(1L);
		elements.add(10L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(9, residue);
	}
	
	@Test
	public void getResidue_Test_With_Three_Small_Numbers(){
		List<Long> elements = new ArrayList<Long>();
		elements.add(1L);
		elements.add(2L);
		elements.add(10L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(7, residue);
	}
	
	@Test
	public void getResidue_Test_With_Four_Small_Numbers(){
		List<Long> elements = new ArrayList<Long>();
		elements.add(1L);
		elements.add(2L);
		elements.add(3L);
		elements.add(10L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(4, residue);
	}
	
	@Test
	public void getResidue_Test_With_Five_Small_Numbers(){
		List<Long> elements = new ArrayList<Long>();
		elements.add(1L);
		elements.add(2L);
		elements.add(3L);
		elements.add(4L);
		elements.add(10L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(0, residue);
	}
	
	
	@Test
	public void getResidue_Test_With_Three_Element(){
		List<Long> elements = new ArrayList<Long>();
		elements.add(120L);
		elements.add(250L);
		elements.add(130L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(0, residue);
	}
	
	@Test
	public void getResidue_Test_With_Zero_Residue(){
		final List<Long> elements = new ArrayList<Long>(5);
		elements.add(7L);
		elements.add(10L);
		elements.add(6L);
		elements.add(8L);
		elements.add(5L);
		NumberPartitionDynamicProgrammingApproach numberPartitionDynamicProgrammingApproach = new NumberPartitionDynamicProgrammingApproach();
		long residue = numberPartitionDynamicProgrammingApproach.getResidue(elements);
		assertEquals(0, residue);
	}
	

	
}
