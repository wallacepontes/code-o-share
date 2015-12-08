package org.codeoshare.jaxrs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TesteCotacaoResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/Cotacao/DollarToReal");
		
		String cotacao = resource.get(String.class);
		System.out.println(cotacao);

	}

}
