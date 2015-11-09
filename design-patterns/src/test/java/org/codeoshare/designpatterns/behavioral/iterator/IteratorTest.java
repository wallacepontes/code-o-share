package org.codeoshare.designpatterns.behavioral.iterator;

import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.Test;

public class IteratorTest {

	@Test
	public void testIterator() throws Exception {
		String[] nomes = new String[4];
		
		nomes[0] = "Fulano";
		nomes[1] = "Sicrano";
		nomes[2] = "Beltrano";
		nomes[3] = "Emiliano";
		
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
		
		assertTrue(true);
	}
}
