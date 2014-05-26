package com.nevermindcorp.algorithms.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nevermindcorp.algorithms.Step;

public class Graph {

	private Set<Node> nodes;
	private List<Step> steps;
 	
	public Graph(){
		nodes = new HashSet<Node>();
	}
	
	public void addNode(Node node){
		nodes.add(node);
	}
	
	public int getNumberOfNodes(){
		return nodes.size();
	}
	
	/**
	 * Returns an ordered set of Edges
	 * @return
	 */
	public Set<Edge> getEdges(){
		Set<Edge> edges = new HashSet<Edge>();
		for(Node node : nodes){
			edges.addAll(node.getEdges());
		}
		return edges;
	}
	
	public Set<Node> getNodes(){
		return nodes;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
}
