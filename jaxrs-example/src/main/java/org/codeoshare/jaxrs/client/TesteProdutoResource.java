package org.codeoshare.jaxrs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import org.codeoshare.jaxrs.entities.Produto;

public class TesteProdutoResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = Client.create();
		
		WebResource resourceXML = client.resource("http://localhost:8080/produtos/1/xml");
		
		System.out.println("TESTANDO COM XML");
		
		String xml = resourceXML.get(String.class);
		System.out.println(xml);
		
		Produto produto1 = resourceXML.get(Produto.class);
		System.out.println(produto1.getId());
		System.out.println(produto1.getNome());
		System.out.println(produto1.getPreco());
		
		WebResource resourceJSON = client.resource("http://localhost:8080/produtos/1/json");
		
		System.out.println("TESTANDO COM JSON");
		
		String json = resourceJSON.get(String.class);
		System.out.println(json);
		
		Produto produto2 = resourceJSON.get(Produto.class);
		System.out.println(produto2.getId());
		System.out.println(produto2.getNome());
		System.out.println(produto2.getPreco());

	}

}
