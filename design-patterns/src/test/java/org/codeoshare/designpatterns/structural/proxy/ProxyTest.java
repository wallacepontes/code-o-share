package org.codeoshare.designpatterns.structural.proxy;

import org.codeoshare.designpatterns.structural.proxy.Conta;
import org.codeoshare.designpatterns.structural.proxy.ContaPadrao;
import org.codeoshare.designpatterns.structural.proxy.ContaProxy;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProxyTest {

	@Test
	public void testProxy() throws Exception {
		Conta contaPadrao = new ContaPadrao();
		Conta contaProxy = new ContaProxy(contaPadrao);
		contaProxy.deposita(100);
		contaProxy.saca(59);
		System.out.println("Saldo: ..." + contaProxy.getSaldo());
		
		assertTrue(true);
	}
}
