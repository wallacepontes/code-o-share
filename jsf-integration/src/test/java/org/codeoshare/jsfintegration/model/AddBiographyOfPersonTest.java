package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddBiographyOfPersonTest {
	@Test
	public void testAddBiographyOfPerson () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person p1 = new Person();
		p1.setFirstName("Sheldon");
		p1.setLastName("Richman");
		p1.setBiography("Sheldon Richman é um escritor político americano, "
				+ "acadêmico, ex-editor da revista The Freeman, atual vice "
				+ "presidente da Future of Freedom Foundation e editor da "
				+ "Future of Freedom, publicação mensal da FFF.");
		
		Person p2 = new Person();
		p2.setFirstName("Jeffrey");
		p2.setLastName("Tucker");
		p2.setBiography("É o presidente da Laissez-Faire Books e consultor "
				+ "editorial do mises.org. É também autor dos livros It's a "
				+ "Jetsons World: Private Miracles and Public Crimes e Bourbon "
				+ "for Breakfast: Living Outside the Statist Quo.");
		
		Person p3 = new Person();
		p3.setFirstName("Roderick");
		p3.setLastName("T. Long");
		p3.setBiography("Roderick T. Long é um filósofo e professor de "
				+ "filosofia na Universidade de Auburn (Alabama, EUA). Autor "
				+ "dos livros 'Reason and Value: Aristotle Versus Rand' e "
				+ "'Wittgenstein, Austrian Economics, and the Logic of Action',"
				+ " é também editor do Journal of Ayn Rand Studies, membro "
				+ "sênior do Mises Institute (MI) e do Center for a Stateless"
				+ " Society (C4SS).");
		
		Person p4 = new Person();
		p4.setFirstName("Murray");
		p4.setLastName("N. Rothbard");
		p4.setBiography("Murray Newton Rothbard é um dos luminares do "
				+ "Liberalismo no séc. XX. Além de um brilhantíssimo "
				+ "economista, foi o maior propulsor e definidor do moderno "
				+ "movimento político libertário. É também o fundador da "
				+ "doutrina que ele chamou de Anarcocapitalismo.");
		
		Person p5 = new Person();
		p5.setFirstName("Kevin");
		p5.setLastName("Carson");
		p5.setBiography("Kevin Carson é um economista mutualista. Autor dos "
				+ "livros 'The Homebrew Industrial Revolution', 'Organization "
				+ "Theory: A Libertarian Perspective' e 'Studies in Mutualist "
				+ "Political Economy', ele é um pesquisador associado do "
				+ "Center for a Stateless Society (C4SS).");
		
		Person p6 = new Person();
		p6.setFirstName("Benjamin");
		p6.setLastName("Tucker");
		p6.setBiography("Benjamin Tucker foi um dos proponentes do anarquismo"
				+ " individualista americano no séc. XIX e propagador do"
				+ " mutualismo. Atuou como tradutor, teórico político e"
				+ " econômico e trabalhou como editor para o jornal anarquista"
				+ " 'Liberty'.");
		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		manager.persist(p5);
		manager.persist(p6);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
