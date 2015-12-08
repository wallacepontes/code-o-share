package org.codeoshare.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/uri-matching")
public class URIMatchingResource {
	@GET
	@Path("/{a: \\d*}/{b: \\d*}")
	@Produces(MediaType.TEXT_PLAIN)
	public String soma(@PathParam("a") double a, @PathParam("b") double b){
	    return a + b + "";
	}
	
	@GET
	@Path("/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String concatena(@PathParam("a") String a, @PathParam("b") String b){
	    return a + b;
	}
}
