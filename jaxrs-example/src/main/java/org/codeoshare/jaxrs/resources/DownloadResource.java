package org.codeoshare.jaxrs.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class DownloadResource {
	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response getText() {
		//File file = new File(".");
        //for(String fileNames : file.list()) System.out.println(fileNames);
		
		File file = new File("state.txt");
		
		ResponseBuilder response = Response.ok((Object)file);
		response.header("Content-Disposition", 
				"attachment; filename=\"state.txt\"");
		return response.build();
	}
	@GET
	@Path("/image")
	@Produces("image/pgn")
	public Response getImage() {
        File file = new File("code-o-share.png");
		
		ResponseBuilder response = Response.ok((Object)file);
		response.header("Content-Disposition", 
				"attachment; filename=\"code-o-share.png\"");
		return response.build();
	}
}
