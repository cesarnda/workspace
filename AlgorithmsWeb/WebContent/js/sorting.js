$(document).ready(function(){
	$("#sortButton").click(function(){
		var elems = $("#elementsToSort").val();
		$("#bodySteps").empty();
		$.post("/AlgorithmsWeb/rest/sort/bubblesort", {elements: elems}, function(data){
			$.each(data.steps, function(index){
				var description = data.steps[index].description;
				var state = data.steps[index].step;
				
				$("#bodySteps").append("<tr><td>" + description + "</td><td>" + state + "</td></tr>");
			});
		});
	});
});