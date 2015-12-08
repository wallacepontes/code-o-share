package org.codeoshare.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/User-Agent")
public class UserAgentResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String userAgent(@HeaderParam("User-Agent") String userAgent){
	  return userAgent;
	}
}
