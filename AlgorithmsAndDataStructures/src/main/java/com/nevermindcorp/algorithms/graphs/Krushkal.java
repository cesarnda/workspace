package com.nevermindcorp.algorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.nevermindcorp.algorithms.Step;

public class Krushkal implements MinimumSpanningTree {

	@Override
	public Graph getMinimumSpanningTree(Graph graph) {
		List<Step> steps = new ArrayList<Step>();
		Set<Edge> edges = graph.getEdges();
		List<Edge> sortedEdges = new ArrayList<Edge>(edges);
		Collections.sort(sortedEdges);
		MSTGraph mstGraph = new MSTGraph();
		int index = 0;
		boolean chosen;
		while(mstGraph.getNumberOfNodes() < graph.getNumberOfNodes()){
			Edge edge = sortedEdges.get(index++);
			chosen = mstGraph.addEdge(edge);
			
		}
		
		mstGraph.setSteps(steps);
		
		return mstGraph;
	}

}
