package edu.harvard.cscie124.graph.mst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.harvard.cscie124.graph.Edge;
import edu.harvard.cscie124.graph.Graph;
import edu.harvard.cscie124.graph.Node;
import edu.harvard.cscie124.sorting.MergeSort;
import edu.harvard.cscie124.sorting.Sorter;

public class Krushkal implements MinimumSpanningTree{
	
	private Sorter sorter;
	
	public Krushkal(){
		sorter = new MergeSort();
	}

	@Override
	public Graph generateMininumSpanningTree(Graph g) {
		List<Edge> edges = new ArrayList<Edge>();
		edges.addAll(g.getEdges());
		sorter.sort(edges);
		Graph mst = new Graph();
		mst.setNodes(g.getNodes());
		mst.setEdges(selectEdgesGreedily(edges, g.getNodes()));
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

}
