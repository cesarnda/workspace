package com.nevermindcorp.algorithms.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node implements Iterable<Edge>{

	private String name;
	private List<Edge> edges;
	
	public Node(String name){
		this.name = name;
		edges = new ArrayList<Edge>();
	}
	
	public void addEdge(Node destination, Double value){
		edges.add(new Edge(value, this, destination));
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = Node.class.cast(obj);
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public Iterator<Edge> iterator() {
		return edges.iterator();
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
}
