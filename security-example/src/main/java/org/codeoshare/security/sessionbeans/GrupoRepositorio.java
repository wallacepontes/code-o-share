package org.codeoshare.security.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.codeoshare.security.entidades.Grupo;

@Stateless
public class GrupoRepositorio {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Grupo g) {
		this.manager.persist(g);
	}

	public List<Grupo> bustaTodos() {
		TypedQuery<Grupo> query = this.manager.createQuery("Select x from Grupo x", Grupo.class);
		return query.getResultList();
	}

}
