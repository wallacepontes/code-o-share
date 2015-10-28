package org.codeoshare.designpatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

	private Map<String,String> propriedades;
	private static Configuration instance;
	
	private Configuration() {
		this.propriedades = new HashMap<String,String>();
		this.propriedades.put("time-zone", "America/Sao_Paulo");
		this.propriedades.put("currency-code", "BRL");
	}
    public static Configuration getInstance() {
    	if (Configuration.instance == null) {
    		Configuration.instance = new Configuration();
    	} 
    	return Configuration.instance;
    	
    }
    public String getPropriedade(String nomeDaPropriedade) {
    	return this.propriedades.get(nomeDaPropriedade);
    }
}
