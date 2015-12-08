package org.codeoshare.jaxrs.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Cotacao")
public class CotacaoResource {
	@GET
	@Path("/DollarToReal")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCotacaoDollarToReal() {
		return "1.6";
	}
	
	@GET
	@Path("/EuroToReal")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCotacaoEuroToReal() {
		return "3.1";
	}
	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String cotacaoForm(@FormParam("M1") String m1, @FormParam("M2") String m2){
	 	return "3.1";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String cotacaoQuey(@QueryParam("M1") String m1, @QueryParam("M2") String m2){
		return "3.1";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String cotacaoMatrix(@MatrixParam("M1") String m1, @MatrixParam("M2") String m2){
		return "3.1";
	}
	
	@GET
	@Path("/{M1}/{M2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String cotacaoParam(@PathParam("M1") String m1, @PathParam("M2") String m2){
	  return "3.1";	
	}*/
}
