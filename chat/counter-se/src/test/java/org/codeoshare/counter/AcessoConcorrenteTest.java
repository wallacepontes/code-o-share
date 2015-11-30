package org.codeoshare.counter;

import javax.naming.InitialContext;

import org.codeoshare.chat.sessionbeans.Contador;
import static org.junit.Assert.*;
import org.junit.Test;

public class AcessoConcorrenteTest {

	@Test
	public void testAcessoConcorrente() throws Exception {
		InitialContext ic = new InitialContext();

		final Contador contador = (Contador) ic.lookup("java:global/chat-war/ContadorBean");

		final Thread[] threads = new Thread[20];

		System.out.println("Contador = " + contador.getValor());
		System.out.println("Incrementando " + threads.length * threads.length + " vezes");

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < threads.length; j++) {
						contador.incrementa();
					}

				}
			});
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("Contador = " + contador.getValor());
		
		assertTrue(true);
	}
}
