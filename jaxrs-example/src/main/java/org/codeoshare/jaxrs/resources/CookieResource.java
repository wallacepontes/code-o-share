package org.codeoshare.jaxrs.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cookie")
public class CookieResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String userAgent(@CookieParam("clienteID") String clienteID){
	 return clienteID;
	}
}
