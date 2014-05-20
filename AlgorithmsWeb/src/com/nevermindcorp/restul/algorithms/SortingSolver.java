package com.nevermindcorp.restul.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nevermindcorp.algorithms.Step;



@Path("sort")
public class SortingSolver {

	private static final Logger logger = LoggerFactory.getLogger(SortingSolver.class);
	private static final Map<String, String> SORTING_METHODS;
	
	static{
		SORTING_METHODS = new HashMap<String, String>();
		for(SortingMethods sortingMethod : SortingMethods.values()){
			SORTING_METHODS.put(sortingMethod.getKey(), sortingMethod.toString());
		}
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public SortingMethodsWrapper getSortingMethod(){
		return new SortingMethodsWrapper(SORTING_METHODS);
	}


	@POST
	@Path("{method}")
	@Produces({MediaType.APPLICATION_JSON})
	public Solution sort(@PathParam("method") String sortingMethod, @FormParam("elements") String elements){
		logger.debug("Method " + sortingMethod + " with elements: " + elements);
		Solution solution = new Solution();		
		solution.setSteps(getSolution(sortingMethod,elements));
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
		
		SortingMethods.valueOf(method).sort(numbers, steps);
		
		return steps;
	}
	
}
