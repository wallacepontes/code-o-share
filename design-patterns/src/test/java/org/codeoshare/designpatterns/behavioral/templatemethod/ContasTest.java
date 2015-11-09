package org.codeoshare.designpatterns.behavioral.templatemethod;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContasTest {

	@Test
	public void testTemplateMethod() throws Exception {
		Conta contaCorrente = new ContaCorrente();
		Conta contaPoupanca = new ContaPoupanca();
		
		contaCorrente.deposita(100);
		contaCorrente.saca(10);
		
		contaPoupanca.deposita(100);
		contaPoupanca.saca(10);
		
		System.out.println("Saldo da conta corrente: "+ contaCorrente.getSaldo());
		assertEquals(89.8, contaCorrente.getSaldo(), 1);
		System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
		assertEquals(89.6, contaPoupanca.getSaldo(), 1);
	}
}