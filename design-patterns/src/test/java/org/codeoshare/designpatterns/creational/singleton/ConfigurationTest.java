package org.codeoshare.designpatterns.creational.singleton;

public class ConfigurationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration configuracao = Configuration.getInstance();
		
		System.out.println(configuracao.getPropriedade("time-zone"));
		System.out.println(configuracao.getPropriedade("currency-code"));
		
	}

}
