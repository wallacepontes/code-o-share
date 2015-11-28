package org.codeoshare.dado;

import javax.naming.InitialContext;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

public class CicloDeVidaSLSBTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();

		for (int i = 0; i < 100; i++) {
			final LancadorDeDado lancadorDeDado = (LancadorDeDado) ic
					.lookup("java:global/dado-war/LancadorDeDadoBean");

			System.out.println("Thread - " + i);

			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					//double random = Math.random();
					//System.out.println("T("+String.valueOf(random).substring(2)+")");

					for (int j = 0; j < 100; j++) {
						System.out.println(lancadorDeDado.lanca());
					}
					//System.out.println("End thread "+ random);
				}
			});
			thread.start();
		}

	}

}
