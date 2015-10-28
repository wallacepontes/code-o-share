package org.codeoshare.designpatterns.creational.prototype;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TestaPrototype {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String nome = "Agileasy";
		Calendar vencimento = Calendar.getInstance();
		vencimento.add(Calendar.DATE, 30);
		Set<String> hashSet = new HashSet<String>();
		
		hashSet.add("curso");
		hashSet.add("java");
		hashSet.add("agileasy");
		
		Campanha campanha = new Campanha(nome, vencimento,hashSet);
		System.out.println(campanha);
		
		Campanha clone = campanha.clone();
		System.out.println(clone);

	}

}
