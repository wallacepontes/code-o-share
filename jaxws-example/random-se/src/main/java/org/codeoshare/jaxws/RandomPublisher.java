package org.codeoshare.jaxws;

import javax.xml.ws.Endpoint;

public class RandomPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Random web service start...");
		Random random = new Random();
		Endpoint.publish("http://localhost:8080/random", random);

	}

}
