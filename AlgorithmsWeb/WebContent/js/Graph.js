function Graph(){
	
	var nodes = [];
	var edges = [];
	
	Graph.prototype.addNode = function(node){
		nodes.push(node);
	};
	
	Graph.prototype.addEdge = function(edge){
		edges.push(edge);
	};
	
	Graph.prototype.getGraph = function(){
		return {'nodes': nodes, 'edges': edges};
	};
	
}