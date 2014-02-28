package edu.harvard.cscie124.graph.mst;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import edu.harvard.cscie124.graph.GraphGenerator;
import edu.harvard.cscie124.graph.Graph;

public class KrushkalTestCase {

	
	@Test
	public void generateMininumSpanningTree_Test_With_6_Nodes_And_2_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(6, 2);
	}
	
	
	private void generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(int numberOfNodes, int dimension){
		GraphGenerator graphGenerator = new GraphGenerator();
		Krushkal krushkal = new Krushkal();
		Graph graph = graphGenerator.generateUndirectedCompleteGraph(numberOfNodes, dimension);
		Graph mst = krushkal.generateMininumSpanningTree(graph);
		System.out.println(mst);
		assertEquals(numberOfNodes - 1, mst.getEdges().size());
	}
}
