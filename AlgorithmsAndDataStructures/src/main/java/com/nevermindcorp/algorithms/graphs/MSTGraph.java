package com.nevermindcorp.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class MSTGraph extends Graph {

	private Set<Edge> edges;
	private Set<Node> nodes;
	
	public MSTGraph(){
		edges = new HashSet<Edge>();
		nodes = new HashSet<Node>();
	}
	
	public boolean contains(Edge edge){
		return edges.contains(edge);
	}
	
	public boolean addEdge(Edge edge){
		if(contains(edge)){
			return false;
		}
		
		edges.add(edge);
		nodes.add(edge.getSource());
		nodes.add(edge.getDestination());
		return true;
	}
	
	@Override
	public Set<Edge> getEdges(){
		return edges;
	}
	
	@Override
	public Set<Node> getNodes(){
		return nodes;
	}
	
	public int getNumberOfNodes(){
		return nodes.size();
	}
	
	public int getNumberOfEdges(){
		return edges.size();
	}
}
