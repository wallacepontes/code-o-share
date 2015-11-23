package org.codeoshare.jsfintegration.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cos_book")
@NamedQuery(name="Book.findByMinimumPrice", 
    query="select b from Book b where b.price > :price")
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="cos_book_author",
	   joinColumns=@JoinColumn(name="boo_id"),
	   inverseJoinColumns=@JoinColumn(name="aut_id"))
	private Collection<Author> authors = new ArrayList<Author>();
	
	private Double price;

	public Long getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
