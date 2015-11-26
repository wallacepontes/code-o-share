package org.codeoshare.jdbc.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.codeoshare.jdbc.entities.Editora;
import org.codeoshare.jdbc.repository.EditoraRepository;

import static org.junit.Assert.*;
import org.junit.Test;

public class InsereEditoraComJPATest {

	@Test
	public void testInsereEditoraComJPA() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cos_jdbcexampledb-pu");
		EntityManager manager = factory.createEntityManager();

		EditoraRepository editoraRepository = new EditoraRepository(manager);

		Editora novoEditora = new Editora();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o nome da editora: ");
		novoEditora.setNome(entrada.nextLine());

		System.out.println("Digite o email da editora: ");
		novoEditora.setEmail(entrada.nextLine());

		editoraRepository.adiciona(novoEditora);

		manager.getTransaction().begin();
		manager.getTransaction().commit();

		manager.close();
		factory.close();

		assertTrue(true);
	}
}
