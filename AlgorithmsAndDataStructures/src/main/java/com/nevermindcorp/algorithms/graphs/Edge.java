package com.nevermindcorp.algorithms.graphs;

public class Edge implements Comparable<Edge>, Cloneable {

	private Double value;
	private Node source;
	private Node destination;
	
	public Edge(Double value, Node source, Node destination){
		this.value = value;
		this.source = source;
		this.destination = destination;
	}
	
	public Node getOtherNode(Node node){
		if(node == null){
			return null;
		}
		if(node.equals(source)){
			return source;
		}
		
		return destination;
	}
	
	public Double getValue(){
		return value;
	}
	
	public Node getSource(){
		return source;
	}
	
	public Node getDestination(){
		return destination;
	}

	@Override
	public int compareTo(Edge o) {
		if(o == null || o.value == null){
			return -1;
		}
		
		if(this.value == null){
			return 1;
		}
		
		return this.value.compareTo(o.value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Edge other = Edge.class.cast(obj);
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "Edge: " + this.source + " -> " + this.destination + " with value " + value;
	}
}
