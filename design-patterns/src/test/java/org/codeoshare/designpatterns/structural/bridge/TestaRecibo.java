package org.codeoshare.designpatterns.structural.bridge;

import org.codeoshare.designpatterns.structural.bridge.GeradorDeArquivoTXT;
import org.codeoshare.designpatterns.structural.bridge.Recibo;

public class TestaRecibo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GeradorDeArquivoTXT gerador = new GeradorDeArquivoTXT();
		Recibo recibo = new Recibo("Agileasy", "Wallace",1000,gerador);
		recibo.geraArquivo();

	}

}
