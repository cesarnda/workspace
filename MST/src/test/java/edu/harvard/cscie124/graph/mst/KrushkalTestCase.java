package edu.harvard.cscie124.graph.mst;

import org.junit.Test;

import edu.harvard.cscie124.graph.GraphGenerator;
import edu.harvard.cscie124.graph.Graph;

public class KrushkalTestCase {

	
	@Test
	public void generateMininumSpanningTree_Test_With_6_Nodes_And_2_Dimensions(){
		GraphGenerator graphGenerator = new GraphGenerator();
		Krushkal krushkal = new Krushkal();
		Graph graph = graphGenerator.generateUndirectedCompleteGraph(6, 2);
		Graph mst = krushkal.generateMininumSpanningTree(graph);
		System.out.println(mst);
	}
	
}
