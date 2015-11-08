package org.codeoshare.designpatterns.behavioral.iterator;

import java.util.Iterator;

public class TestaIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] nomes = new String[4];
		
		nomes[0] = "Fulano";
		nomes[1] = "Sicrano";
		nomes[2] = "Beltrano";
		
		ListaDeNomes listaDeNomes = new ListaDeNomes(nomes);
		Iterator<String> iterator = listaDeNomes.iterator();
		
		iterator.hasNext();
		iterator.remove();
		
		while (iterator.hasNext()) {
			String nome = iterator.next();
			System.out.println(nome);
		}
		
		System.out.println("-------------");
		System.out.println("Testando foreach");
		
		for (String nome : listaDeNomes) {
			System.out.println(nome);
		}
		

	}
}
