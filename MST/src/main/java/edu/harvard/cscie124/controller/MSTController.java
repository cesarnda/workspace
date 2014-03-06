package edu.harvard.cscie124.controller;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.cscie124.graph.BigGraphGenerator;
import edu.harvard.cscie124.graph.Graph;
import edu.harvard.cscie124.graph.GraphGenerator;
import edu.harvard.cscie124.graph.mst.Krushkal;

public class MSTController {

	private static final Logger logger = LoggerFactory.getLogger(MSTController.class);

	
	public static void main(String[] args) {
		

	}
	
	public void executeMST(int flag, int numberOfNodes, int numberOfTrials, int dimension){
		logger.trace("Running Krushak with " + numberOfNodes + " nodes in R " + dimension);
		double mstWeightAverage = 0.0;
		double mstWeight;
		for(int index = 0; index < numberOfTrials; index++){
			Graph mst = generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(numberOfNodes, dimension);
			mstWeight= mst.getMininumSpanningTreeWeight();
			mstWeightAverage += mstWeight;
			logger.trace((index + 1) + "th run and minimum spanning weight for n = " + numberOfNodes + " and d = " + dimension + " is " + mstWeight);
		}
		logger.info("The average minimum spanning weight for n = " + numberOfNodes + " and d = " + dimension + " is " + (mstWeightAverage / numberOfTrials));
	}

	private Graph generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(int numberOfNodes, int dimension){
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		for (String argument : arguments) {
			System.out.print(argument + " ");
		}

		GraphGenerator graphGenerator = new GraphGenerator();
		Krushkal krushkal = new Krushkal();
		Graph mst = null;
		if(numberOfNodes > 2048){
			BigGraphGenerator bigGraphGenerator = new BigGraphGenerator(numberOfNodes, dimension);
			mst = krushkal.generateMininumSpanningTreeForBigGraph(bigGraphGenerator.getNodes(), bigGraphGenerator);
		}else{
			Graph graph = graphGenerator.generateUndirectedCompleteGraph(numberOfNodes, dimension);
			 mst = krushkal.generateMininumSpanningTree(graph);
		}
		
		return mst;
	}
	
}
