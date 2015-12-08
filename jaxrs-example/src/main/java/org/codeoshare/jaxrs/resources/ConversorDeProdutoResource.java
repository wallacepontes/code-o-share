package org.codeoshare.jaxrs.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codeoshare.jaxrs.entities.Produto;

@Path("/produtos/converte")
public class ConversorDeProdutoResource {
	@POST
	@Path("/json/xml")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Produto transformToXML(Produto p) {
		return p;
	}
	
	@POST
	@Path("/xml/json")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Produto transformToJSON(Produto p) {
		return p;
	}
}
