package edu.harvard.cscie124.pa3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.harvard.cscie124.pa3.heuristic.HillClimbingTestCases;
import edu.harvard.cscie124.pa3.heuristic.KarmarkarKarpTestCase;
import edu.harvard.cscie124.pa3.heuristic.MixedHillClimbingTestCases;
import edu.harvard.cscie124.pa3.heuristic.MixedRandomRepeatedTestCases;
import edu.harvard.cscie124.pa3.heuristic.MixedSimulatedAnnealingTestCases;
import edu.harvard.cscie124.pa3.heuristic.RandomRepeatedTestCases;
import edu.harvard.cscie124.pa3.heuristic.SimulatedAnnealingTestCases;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	NumberPartitionDynamicProgrammingApproachTestCases.class,
	KarmarkarKarpTestCase.class,
	KKTestCases.class,
	RandomRepeatedTestCases.class,
	HillClimbingTestCases.class,
	SimulatedAnnealingTestCases.class,
	MixedRandomRepeatedTestCases.class,
	MixedHillClimbingTestCases.class,
	MixedSimulatedAnnealingTestCases.class,
	PrintResultsForLatex.class
})
public class NumberPartitionTestSuite {

}
