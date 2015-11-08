package org.codeoshare.designpatterns.structural.flyweight;

import java.util.Arrays;

public class TemaCodeOshare implements TemaFlyweight {

	public void imprime(String titulo, String texto) {
		System.out.println("########## " + titulo.toUpperCase() + " ##########");
		System.out.println(texto);
		char[] rodapeE = new char[(int) Math.floor((6+titulo.length())/2.0) ];
		char[] rodapeD = new char[(int) Math.ceil((6+titulo.length())/2.0)];
		Arrays.fill(rodapeE,'#');
		Arrays.fill(rodapeD,'#');
		System.out.println(new String(rodapeE) + " www.codeOshare.org " + new String(rodapeD));
	}
}
