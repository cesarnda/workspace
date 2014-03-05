package edu.harvard.cscie124.graph;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class GraphGenerator {
	
	private Random random;
	
	public GraphGenerator(){
		random = new Random();
	}
	
	public Graph generateUndirectedCompleteGraph(int numberOfNodes, int dimension){
		Graph graph = new Graph();
		Set<Node> nodes = new HashSet<Node>();
		for(int index = 0; index < numberOfNodes; index++){
			Node node = new Node("" + index, generateCoordinates(dimension));
			nodes.add(node);
		}
		
		graph.setNodes(nodes);
		graph.setEdges(generateEdges(nodes));
		System.out.println("Generated graph with " + graph.getNodes().size() + " nodes and " + graph.getEdges().size() + " edges");
		return graph;
	}
	
	private Set<Edge> generateEdges(Set<Node> nodes){
		int numberOfNodes = nodes.size();
		Node[] nodesInArray = nodes.toArray(new Node[numberOfNodes]);
		Set<Edge> edges = new HashSet<Edge>();
		int indexForDestination;
		int counter = 0;
		try{
		for(int indexForSource = 0; indexForSource < nodes.size() - 1; indexForSource++){
			for(indexForDestination = indexForSource + 1; indexForDestination < nodes.size(); indexForDestination++){
				Edge edge = new Edge(nodesInArray[indexForSource], nodesInArray[indexForDestination]);
				counter++;
				edges.add(edge);
			}
		}
		}catch(Error e){
			throw new Error("Counter: " + counter, e);
		}
		return edges;
	}
	
	private Double[] generateCoordinates(int dimension){
		Double[] coordinates = new Double[dimension];
		for(int index = 0; index < dimension; index++){
			coordinates[index] = random.nextDouble();
		}
		return coordinates;
	}

}