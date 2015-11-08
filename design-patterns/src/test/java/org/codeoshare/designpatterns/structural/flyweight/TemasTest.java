package org.codeoshare.designpatterns.structural.flyweight;

import org.codeoshare.designpatterns.structural.flyweight.Apresentacao;
import org.codeoshare.designpatterns.structural.flyweight.Slide;
import org.codeoshare.designpatterns.structural.flyweight.TemaFlyweightFactory;

import static org.junit.Assert.*;
import org.junit.Test;

public class TemasTest {

	@Test
	public void testFlyweight() throws Exception {
		Apresentacao a = new Apresentacao();
		a.adicionaSlide(new Slide(TemaFlyweightFactory
				.getTema(TemaFlyweightFactory.Code_O_Share), 
				"OO em Java", "Com este curso vc vai obter uma base."));
		a.adicionaSlide(new Slide(TemaFlyweightFactory
				.getTema(TemaFlyweightFactory.ASTERISCO), 
				"Desenvolvimento Web", "Você poderá desenvolver apps web."));
		a.adicionaSlide(new Slide(TemaFlyweightFactory
				.getTema(TemaFlyweightFactory.HIFEN), 
				"Persistencia e Hibernate", "Aprofudamento na persistência."));
		
		a.imprime();
		
		assertTrue(true);
	}
}
