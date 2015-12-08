package org.codeoshare.jaxrs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import org.codeoshare.jaxrs.entities.Produto;

public class TesteConversorDeProdutoResource {
	public static void main(String[] args) {
		Produto p = new Produto();
		p.setId(1L);
		p.setNome("Bola");
		p.setPreco(45.67);
		
		Client client = Client.create();
		
		System.out.println("Convertendo para XML");
		WebResource resource1 = client.resource("http://localhost:8080/produtos/converte/json/xml");
		String xml = resource1.type("application/json").post(String.class, p);
		System.out.println(xml);
	
		System.out.println("Convertendo para JSON");
		WebResource resource2 = client.resource("http://localhost:8080/produtos/converte/xml/json");
		String json = resource2.type("application/xml").post(String.class, p);
		System.out.println(json);
	}
}
