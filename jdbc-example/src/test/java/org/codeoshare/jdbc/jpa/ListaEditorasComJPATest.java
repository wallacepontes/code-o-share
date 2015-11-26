package org.codeoshare.jdbc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.codeoshare.jdbc.entities.Editora;
import org.codeoshare.jdbc.repository.EditoraRepository;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListaEditorasComJPATest {

	@Test
	public void testListaEditorasComJPA() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cos_jdbcexampledb-pu");
		EntityManager manager = factory.createEntityManager();

		EditoraRepository editoraRepository = new EditoraRepository(manager);

		List<Editora> editoras = editoraRepository.buscaTodas();
		for (Editora editora : editoras) {
			System.out.printf("%d : %s - %s\n", editora.getId(), editora.getNome(), editora.getEmail());
		}

		manager.close();
		factory.close();

		assertNotNull(editoras);
	}
}
