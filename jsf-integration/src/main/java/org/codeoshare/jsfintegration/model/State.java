package org.codeoshare.jsfintegration.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cos_state")
public class State {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@OneToOne(optional=false, cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="gov_id")
	private Governor governador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Governor getGovernador() {
		return governador;
	}

	public void setGovernador(Governor governador) {
		this.governador = governador;
	}
}