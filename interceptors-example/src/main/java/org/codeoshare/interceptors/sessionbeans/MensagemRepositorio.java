package org.codeoshare.interceptors.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.codeoshare.interceptors.entities.Mensagem;
import org.codeoshare.interceptors.interceptors.CensuraInterceptor;

@Stateless
public class MensagemRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Interceptors({CensuraInterceptor.class})
	public void adiciona(Mensagem mensagem) {
		this.manager.persist(mensagem);
	}
	
	public List<Mensagem> getMensagens() {
		TypedQuery<Mensagem> query = this.manager.createQuery("select x from Mensagem x", Mensagem.class);
		return query.getResultList();
	}
}
