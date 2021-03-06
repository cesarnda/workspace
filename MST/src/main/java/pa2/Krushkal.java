package edu.harvard.cscie124.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.cscie124.graph.Edge;
import edu.harvard.cscie124.graph.Graph;
import edu.harvard.cscie124.graph.Node;
import edu.harvard.cscie124.sorting.Sorter;

public class Krushkal implements MinimumSpanningTree{
	
	private static final Logger logger = LoggerFactory.getLogger(Krushkal.class);

	private Sorter sorter;
	
	public Krushkal(){
		sorter = new Sorter(){

			@Override
			public <T extends Comparable<? super T>> void sort(
					List<T> unsortedList) {
				Collections.sort(unsortedList);
			}
			
		};
	}

	@Override
	public Graph generateMininumSpanningTree(Graph g) {
		List<Edge> edges = new ArrayList<Edge>();
		edges.addAll(g.getEdges());
		int numberOfEdges = edges.size();
		long startTimeOverAll = System.currentTimeMillis();
		long startTimeForSorting = System.currentTimeMillis();
		sorter.sort(edges);
		long timeTakenToSort = System.currentTimeMillis() - startTimeForSorting;
		logger.debug("It took " + timeTakenToSort + " milliseconds to sort " + edges.size() + " edges");
		long startTime = System.currentTimeMillis();
		Graph mst = new Graph();
		mst.setNodes(g.getNodes());
		mst.setEdges(selectEdgesGreedily(edges, g.getNodes()));
		long timeTaken = System.currentTimeMillis() - startTime;
		long timeTakenOverAll = System.currentTimeMillis() - startTimeOverAll;
		logger.debug("Krushkal took " + timeTaken + " milliseconds for " + g.getNodes().size() + " nodes and " + numberOfEdges + " edges.");
		logger.debug("Krushkal took " + timeTakenOverAll + " milliseconds over all for " + g.getNodes().size() + " nodes and " + numberOfEdges + " edges.");

		return mst;
	}
	
	public Set<Edge> selectEdgesGreedily(List<Edge> edges, Set<Node> nodes){
		int numberOfEdgesInMST = nodes.size() - 1;
		Set<Edge> edgesForMST = new HashSet<Edge>();
		Set<Node> nodesInMST = new HashSet<Node>();
		
		while(edgesForMST.size() < numberOfEdgesInMST){
			Edge edgeWithMinimumWeigth = edges.remove(0);
			if(nodesInMST.contains(edgeWithMinimumWeigth.getSource()) && edgesForMST.contains(edgeWithMinimumWeigth.getDestination())){
				continue;
			}
			edgesForMST.add(edgeWithMinimumWeigth);
			nodesInMST.add(edgeWithMinimumWeigth.getSource());
			nodesInMST.add(edgeWithMinimumWeigth.getDestination());
		}
		
		return edgesForMST;
	}
	
	public Graph generateMininumSpanningTreeForBigGraph(Set<Node> nodes, Iterable<Edge> edgeFetcher){
		long startTime = System.currentTimeMillis();
	
		Graph graph = new Graph();
		graph.setNodes(nodes);
		graph.setEdges(selectEdgesGreedilyForBigGraph(nodes, edgeFetcher));
		
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.debug("Krushkal for Big Graphs took " + timeTaken + " for a complete graph with " + nodes.size() + " nodes");
		return graph;
	}
	
	public Set<Edge> selectEdgesGreedilyForBigGraph(Set<Node> nodes, Iterable<Edge> edgeFetcher){
		int batchBlock = 1_000_000;
		Set<Edge> edgesForMST = new HashSet<Edge>();
		Set<Edge> partialEdges = new TreeSet<Edge>();
		List<Edge> partialEdgesArray = new LinkedList<Edge>();
		int numberOfElementsTreated = 0;
		int counter = 0;
		long startTime = System.currentTimeMillis();
		for(Edge edge : edgeFetcher){
			if(edge == null){
				break;
			}
			partialEdges.add(edge);
			counter++;
			if(counter == batchBlock){
				logger.trace("Sorting " + partialEdges.size() + " edges");
				partialEdgesArray.addAll(partialEdges);
				logger.trace("Finished sorting " + partialEdgesArray.size() + " edges");
				edgesForMST = selectEdgesGreedily(partialEdgesArray, nodes);
				counter = 0;
				numberOfElementsTreated += batchBlock;
				logger.trace("Number of elements treated so far: " + numberOfElementsTreated + " in " + (System.currentTimeMillis() - startTime) + " milliseconds");
				partialEdges.clear();
				partialEdgesArray.clear();
				partialEdges.addAll(edgesForMST);
			}
		}
		
		partialEdges.addAll(edgesForMST);
		edgesForMST = selectEdgesGreedily(new ArrayList<Edge>(partialEdges), nodes);
		
		return edgesForMST;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}
	
}
