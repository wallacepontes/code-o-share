package org.codeoshare.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/http-headers")
public class HttpHeadersResource {
	@GET
	public String addUser(@Context HttpHeaders headers) {
		String userAgent = headers.getRequestHeader("user-agent").get(0);
		return "user-agent: " + userAgent;
	}
}
