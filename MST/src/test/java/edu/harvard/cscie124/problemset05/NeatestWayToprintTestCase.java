package edu.harvard.cscie124.problemset05;

import org.junit.Test;

public class NeatestWayToprintTestCase {

	
	@Test
	public void neatPrint_Test_With_Small_Text(){
		final String TEST = "Hello World, this is dynamic programming and it is really hard to come up with the solution.";
		NeatestWayToprint print = new NeatestWayToprint();
		print.neatPrint(TEST, 12);
		
	}
	
	
	@Test
	public void neatPrint_Test_With_Tiny_Text(){
		final String TEST = "Hello World and you all folks from US and America";
		NeatestWayToprint print = new NeatestWayToprint();
		print.neatPrint(TEST, 8);
		
	}
	
	@Test
	public void neatPrint_Test_With_Tiny_Text_01(){
		final String TEST = "Hello World and you all folks from US and Ame.";
		NeatestWayToprint print = new NeatestWayToprint();
		print.neatPrint(TEST, 8);
		
	}
	
}
