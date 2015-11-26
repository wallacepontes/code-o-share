package org.codeoshare.futebol.model.repositories;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codeoshare.futebol.model.entities.Jogador;
import org.codeoshare.futebol.model.entities.Time;

public class TimeRepository {
    private EntityManager manager;

    public TimeRepository(EntityManager manager) {
    	this.manager = manager;
    }
    public void adiciona(Time time) {
    	this.manager.persist(time);
    }
    public Time procura(Long id) {
    	return this.manager.find(Time.class, id);
    }
    public void remove(Long id) {
    	Time time = this.procura(id);
    	Query query = this.manager.createQuery("select x from Jogador x");
    	List<Jogador> jogadores = query.getResultList();
    	for (Jogador jogador : jogadores) {
    		//TODO fazer apenas para o time a ser removido
			jogador.setTime(null);
		}
    	this.manager.remove(time);
    }
    public Time atualiza(Time time) {
    	return this.manager.merge(time);
    }
    public List<Time> getLista() {
    	Query query = this.manager.createQuery("select x from Time x");
    	return query.getResultList();
    }
}
