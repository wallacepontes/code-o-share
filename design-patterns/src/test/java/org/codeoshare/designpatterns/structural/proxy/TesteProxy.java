package org.codeoshare.designpatterns.structural.proxy;

import org.codeoshare.designpatterns.structural.proxy.Conta;
import org.codeoshare.designpatterns.structural.proxy.ContaPadrao;
import org.codeoshare.designpatterns.structural.proxy.ContaProxy;

public class TesteProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conta contaPadrao = new ContaPadrao();
		Conta contaProxy = new ContaProxy(contaPadrao);
		contaProxy.deposita(100);
		contaProxy.saca(59);
		System.out.println("Saldo: ..." + contaProxy.getSaldo());

	}

}
