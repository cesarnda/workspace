package edu.harvard.cscie124.graph;

public class Edge implements Comparable<Edge>{
	
	private Node source;
	private Node destination;
	private Double weight;
	
	public Edge(Node source, Node destination){
		this.source = source;
		this.destination = destination;
		Double[] sourceCoordinates = this.source.getCoordinates();
		Double[] destinationCoordinates = this.destination.getCoordinates();
		weight = 0.0;
		for(int index = 0; index < sourceCoordinates.length; index++){
			weight +=  Math.pow(destinationCoordinates[index] - sourceCoordinates[index], 2); 
		}
		weight = Math.sqrt(weight);
	}
	
	public Node getSource() {
		return source;
	}
	
	public void setSource(Node source) {
		this.source = source;
	}
	
	public Node getDestination() {
		return destination;
	}
	
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge) {
		if(this.weight == null){
			return 1;
		}
		return this.weight.compareTo(edge.getWeight());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		Edge other = (Edge) obj;
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
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
