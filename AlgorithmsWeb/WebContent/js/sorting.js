$(document).ready(function(){
	$.getJSON("/AlgorithmsWeb/rest/sort", function(data){
		for(var key in data.sortingMethods){
			$("#sortingOptions").append("<option value='" + key + "'>" + data.sortingMethods[key] + "</option>");
		}
	});
	
	
	$("#sortButton").click(function(){
		var elems = $("#elementsToSort").val();
		$("#bodySteps").empty();
		$.post("/AlgorithmsWeb/rest/sort/" + $("#sortingOptions").val(), {elements: elems}, function(data){
			$.each(data.steps, function(index){
				var description = data.steps[index].description;
				var state = data.steps[index].step;
				
				$("#bodySteps").append("<tr><td>" + description + "</td><td>" + state + "</td></tr>");
			});
		});
	});
});