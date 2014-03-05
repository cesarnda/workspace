package edu.harvard.cscie124.graph.mst;

import static org.junit.Assert.assertEquals;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import org.junit.Test;

import edu.harvard.cscie124.graph.Graph;
import edu.harvard.cscie124.graph.GraphGenerator;

public class KrushkalTestCase {

	
	@Test
	public void generateMininumSpanningTree_Test_With_6_Nodes_And_2_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(6, 2);
	}
	
	//@Test
	public void generateMininumSpanningTree_Test_With_65536_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(65536, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_32768_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(32768, 4);
	}
	
	/*
	@Test
	public void generateMininumSpanningTree_Test_With_16384_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(16384, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_8192_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(8192, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_4096_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(4096, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_2048_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(2048, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_1024_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(1024, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_512_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(512, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_256_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(256, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_128_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(128, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_64_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(64, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_32_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(32, 4);
	}
	
	@Test
	public void generateMininumSpanningTree_Test_With_16_Nodes_And_4_Dimensions(){
		generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(16, 4);
	}
	
	*/
	private void generateMinimumSpanningTree_Test_With_N_Nodes_And_D_Dimensions_From_A_Complete_Graph(int numberOfNodes, int dimension){
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		for (String argument : arguments) {
			System.out.print(argument + " ");
		}
		System.out.println();
		
		System.out.println("Running Krushkal with " + numberOfNodes + " nodes in R " + dimension);
		GraphGenerator graphGenerator = new GraphGenerator();
		Krushkal krushkal = new Krushkal();
		Graph graph = graphGenerator.generateUndirectedCompleteGraph(numberOfNodes, dimension);
		Graph mst = krushkal.generateMininumSpanningTree(graph);
		System.out.println(mst);
		assertEquals(numberOfNodes - 1, mst.getEdges().size());
	}
}
