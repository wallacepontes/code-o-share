package org.codeoshare.jsfintegration.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cos_book")
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="cos_boo_auth",
	   joinColumns=@JoinColumn(name="boo_id"),
	   inverseJoinColumns=@JoinColumn(name="aut_id"))
	private Collection<Author> authors = new ArrayList<Author>();

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

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}
}
