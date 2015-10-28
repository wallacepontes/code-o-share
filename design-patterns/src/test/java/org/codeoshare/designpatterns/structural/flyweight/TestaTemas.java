package org.codeoshare.designpatterns.structural.flyweight;

import org.codeoshare.designpatterns.structural.flyweight.Apresentacao;
import org.codeoshare.designpatterns.structural.flyweight.Slide;
import org.codeoshare.designpatterns.structural.flyweight.TemaFlyweightFactory;

public class TestaTemas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apresentacao a = new Apresentacao();
		a.adicionaSlide(new Slide(TemaFlyweightFactory
				.getTema(TemaFlyweightFactory.AGILEASY), 
				"OO em Java", "Com este curso vc vai obter uma base."));
		a.adicionaSlide(new Slide(TemaFlyweightFactory
				.getTema(TemaFlyweightFactory.ASTERISCO), 
				"Desenvolvimento Web", "Você poderá desenvolver apps web."));
		a.adicionaSlide(new Slide(TemaFlyweightFactory
				.getTema(TemaFlyweightFactory.HIFEN), 
				"Persistencia e Hibernate", "Aprofudamento na persistência."));
		
		a.imprime();
	}
}
