package resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.nevermindcorp.algorithms.Step;

@Path("sort")
public class SortingSolver {

	@GET
	public List<Step> sort(@QueryParam("sorting") String sortingMethod, List<Integer> elements){
		return null;
	}
	
}
