function Edge(nodeSource, nodeDest, weight){
	var source = nodeSource;
	var destination = nodeDest;
	var value = weight;
	
	Edge.prototype.getEdge = function(){
		return {'source': source, 'destination': destination, 'value': value};
	};
}