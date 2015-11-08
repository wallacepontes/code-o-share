package org.codeoshare.designpatterns.structural.bridge;

import org.codeoshare.designpatterns.structural.bridge.GeradorDeArquivoTXT;
import org.codeoshare.designpatterns.structural.bridge.Recibo;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ReciboTest {

	@Test
	public void testBridge() throws Exception {
		GeradorDeArquivoTXT gerador = new GeradorDeArquivoTXT();
		Recibo recibo = new Recibo("Company Sa", "Fulano",1000,gerador);
		recibo.geraArquivo();
		
		File file = new File("arquivo.txt");

		assertTrue(file.exists());

		if (file.exists()) {
			file.delete();
		}
	}
}
