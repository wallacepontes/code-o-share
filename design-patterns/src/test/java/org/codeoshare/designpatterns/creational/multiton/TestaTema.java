package org.codeoshare.designpatterns.creational.multiton;

public class TestaTema {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tema temaFire = Tema.getInstance(Tema.FIRE);
		System.out.println("Tema " + temaFire.getNome());
		System.out.println("Cor Da Fonte : " + temaFire.getCorDaFonte());
		System.out.println("Cor Do Fundo : " + temaFire.getCorDoFundo());
		
		Tema temaSky = Tema.getInstance(Tema.SKY);
		System.out.println("Tema " + temaSky.getNome());
		System.out.println("Cor Da Fonte : " + temaSky.getCorDaFonte());
		System.out.println("Cor Do Fundo : " + temaSky.getCorDoFundo());

	}

}
