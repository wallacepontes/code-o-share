package org.codeoshare.designpatterns.behavioral.iterator;

import java.util.Iterator;

public class TestaIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] nomes = new String[4];
		
		nomes[0] = "Wallace Pontes";
		nomes[1] = "Lucas Pontes";
		nomes[2] = "Bia Mates";
		nomes[3] = "Michel Mates";
		
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
