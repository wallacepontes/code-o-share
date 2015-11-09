package org.codeoshare.designpatterns.behavioral.command;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListaDeComandosTest {

	@Test
	public void testCommand() throws Exception {
		Player player = new Player();
		ListaDeComandos lista = new ListaDeComandos();
		
		lista.adiciona(new TocaMusicaComando(player, "musical.mp3"));
		lista.adiciona(new AumentaVolumeComando(player, 3));
		lista.adiciona(new TocaMusicaComando(player, "musica2.mp3"));
		lista.adiciona(new DiminuiVolumeComando(player, 2));
		lista.adiciona(new TocaMusicaComando(player, "musica3.mp3"));

		lista.executa();
		
		assertTrue(true);
	}

}
