package com.nevermindcorp.restul.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nevermindcorp.algorithms.Step;
import com.nevermindcorp.algorithms.sorting.SelectionSort;



@Path("sort/{method}")
public class SortingSolver {

	private static final Logger logger = LoggerFactory.getLogger(SortingSolver.class);


	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Solution sort(@PathParam("method") String sortingMethod, @FormParam("elements") String elements){
		logger.debug("Method " + sortingMethod + " with elements: " + elements);
		Solution solution = new Solution();		
		solution.setSteps(getSolution("",elements));
		return solution;
	}
	
	
	private List<Step> getSolution(String method, String query){
		List<Step> steps = new ArrayList<Step>();
		if(query == null || query.trim().length() < 1){
			return steps;
		}
		String[] elements = query.split(" ");
		List<Double> numbers = new ArrayList<Double>(elements.length);
		
		for(String element : elements){
			numbers.add(Double.valueOf(element));
		}
		
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(numbers, steps);
		
		return steps;
	}
	
}
