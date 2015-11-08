package org.codeoshare.designpatterns.structural.decorator;

import org.codeoshare.designpatterns.structural.decorator.Emissor;
import org.codeoshare.designpatterns.structural.decorator.EmissorBasivo;
import org.codeoshare.designpatterns.structural.decorator.EmissorDecoratorComCompressao;
import org.codeoshare.designpatterns.structural.decorator.EmissorDecoratorComCriptografia;

import static org.junit.Assert.*;
import org.junit.Test;

public class EmissorDecoratorTest {

	@Test
	public void testDecorator() throws Exception {
		String mensagem = "Code-O-Share";
		
		Emissor emissorCript = new EmissorDecoratorComCriptografia(new EmissorBasivo());
		emissorCript.envia(mensagem);
		
		Emissor emissorCompr = new EmissorDecoratorComCompressao(new EmissorBasivo());
		emissorCompr.envia(mensagem);
		
		Emissor emissorCriptCompr = new EmissorDecoratorComCriptografia(new EmissorDecoratorComCompressao(new EmissorBasivo()));
		emissorCriptCompr.envia(mensagem);
		
		assertTrue(true);
	}
}
