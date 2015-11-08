package org.codeoshare.designpatterns.creational.objectpool;

import static org.junit.Assert.*;
import org.junit.Test;

public class PoolTest {

	@Test
	public void testFuncionarioObjectPool() throws Exception {
		Pool<Funcionario> funcionarioPool = new FuncionarioPool();
        Funcionario funcionario = funcionarioPool.acquire();

		while (funcionario != null) {
		    System.out.println(funcionario.getNome());
		    funcionario = funcionarioPool.acquire();
		}
		
		assertNull(funcionario);
	}

	@Test
	public void testSalaObjectPool() throws Exception {
		Pool<Sala> salaPool = new SalaPool();
        Sala sala = salaPool.acquire();

		while (sala != null) {
		    System.out.println(sala.getNumero());
		    sala = salaPool.acquire();
		}
		
		assertNull(sala);
	}
}
