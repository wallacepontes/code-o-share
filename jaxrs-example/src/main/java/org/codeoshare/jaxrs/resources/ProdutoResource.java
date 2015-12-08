package org.codeoshare.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codeoshare.jaxrs.entities.Produto;

@Path("/produtos")
public class ProdutoResource {
	
	@GET
	@Path("/{id}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Produto getProdutoAsXML(@PathParam("id") long id) {
		return this.geraProdutoFalso(id);
	}
	
	@GET
	@Path("/{id}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProdutoAsJSON(@PathParam("id") long id) {
		return this.geraProdutoFalso(id);
	}
	public Produto geraProdutoFalso(long id) {
		Produto p = new Produto();
		p.setId(id);
		p.setNome("produto" + id);
		p.setPreco(50.0 * id);
		
		return p;
		
	}
}
