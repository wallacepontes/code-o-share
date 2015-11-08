package org.codeoshare.designpatterns.creational.prototype;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrototypeTest {

	@Test
	public void testPrototype() throws Exception {
		String nome = "Code-O-Share";
		Calendar vencimento = Calendar.getInstance();
		vencimento.add(Calendar.DATE, 30);
		Set<String> hashSet = new HashSet<String>();
		
		hashSet.add("khanacademy");
		hashSet.add("ed.ted");
		hashSet.add("udacity");
		
		Campanha campanha = new Campanha(nome, vencimento,hashSet);
		System.out.println(campanha);
		
		Campanha clone = campanha.clone();
		System.out.println(clone);
		
		assertNotEquals(campanha, clone);
	}
}
