package edu.harvard.cscie124.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigGraphGenerator implements Iterator<Edge>, Iterable<Edge>{
	
	private static final Logger logger = LoggerFactory.getLogger(BigGraphGenerator.class);
	
	private int numberOfNodes;
	private List<Node> nodes;
	private Random random;
	private int currentNumberOfEdges;
	private int maximumNumberOfEdges;
	private int indexNodeSource;
	private int indexNodeDestination;
	
	public BigGraphGenerator(int numberOfNodes, int dimension){
		random = new Random();
		this.numberOfNodes = numberOfNodes;
		this.maximumNumberOfEdges = numberOfNodes * (numberOfNodes - 1) / 2;
		this.indexNodeSource = 0;
		this.indexNodeDestination = 1;
		nodes = generateNodes(numberOfNodes, dimension);
	}
	
	public Set<Node> getNodes(){
		return new HashSet<Node>(nodes);
	}
	
	private List<Node> generateNodes(int numberOfNodes, int dimension){
		List<Node> nodes = new ArrayList<Node>();
		for(int index = 0; index < numberOfNodes; index++){
			Node node = new Node("" + index, generateCoordinates(dimension));
			nodes.add(node);
		}
		return nodes;
	}
	
	private Double[] generateCoordinates(int dimension){
		Double[] coordinates = new Double[dimension];
		for(int index = 0; index < dimension; index++){
			coordinates[index] = random.nextDouble();
		}
		return coordinates;
	}

	@Override
	public boolean hasNext() {
		return currentNumberOfEdges < maximumNumberOfEdges;
	}

	@Override
	public Edge next() {
		return getNextEdge();
	}
	
	private Edge getNextEdge(){
		if(indexNodeDestination >= numberOfNodes - 1){
			indexNodeSource++;
			indexNodeDestination = indexNodeSource;
		}
		
		if(indexNodeSource >= numberOfNodes - 1){
			return null;
		}
		
		indexNodeDestination++;
		
		currentNumberOfEdges++;
		Edge edge = new Edge(nodes.get(indexNodeSource), nodes.get(indexNodeDestination));
		logger.trace("Generated " + currentNumberOfEdges + " edges " + edge);
		return edge;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Edge> iterator() {
		return this;
	}

}
