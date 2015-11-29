package org.codeoshare.dado;

import javax.naming.InitialContext;

import static org.junit.Assert.*;
import org.junit.Test;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

public class CicloDeVidaSLSBTest {
	/**
	 * Invoke GlassFish management console : 
	 *         http://localhost:4848/common/index.jsf
	 * 
	 * --> Configurations -> server-config -> EJB Container
	 * Change the values:
	 *   - Maximum Pool Size: 32 to 5
	 *   - Pool Idle Timeout: 600 to 10
	 * 
	 * Restart the server, and test again.
	 *  
	 * @throws Exception
	 */
	@Test
	public void testCicloDeVidaSLSB() throws Exception {
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
		
		assertTrue(true);

	}

}
