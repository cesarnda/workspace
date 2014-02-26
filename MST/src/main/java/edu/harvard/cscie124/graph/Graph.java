package edu.harvard.cscie124.graph;

import java.util.Set;

public class Graph {

	private Set<Node> nodes;
	private Set<Edge> edges;
	
	public Set<Node> getNodes() {
		return nodes;
	}
	
	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
	
	public Set<Edge> getEdges() {
		return edges;
	}
	
	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}
	
	public Double getMininumSpanningTreeWeight(){
		Double mstWeight = 0.0;
		for(Edge edge : edges){
			mstWeight += edge.getWeight();
		}
		return mstWeight;
	}
	
	@Override
	public String toString(){
		return "Nodes: " + nodes + "\nEdges: " + edges + "\nMinimum Spanning Weigth: " + getMininumSpanningTreeWeight();
	}
}
