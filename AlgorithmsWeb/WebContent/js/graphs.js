$(document).ready(function(){
	var graph =  Object.create(Graph.prototype);
	var canvas = document.getElementById('graphCanvas');
	var context = canvas.getContext('2d');
	var radius = 20;
	$("#graphCanvas").click(function(e){
		var rect = canvas.getBoundingClientRect();
		
		var x = e.clientX - rect.left;
		var y = e.clientY - rect.top;
		context.beginPath();
		context.arc(x, y, radius, 0, 2 * Math.PI, false);
		context.fillStyle = 'blue';
		context.fill();
		context.closePath();
	});

});