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
@Table(name="cos_author")
@NamedQuery(name="Author.findAll", 
query="select distinct(a) from Author a left join fetch a.books")
public class Author {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="cos_book_author",
	   joinColumns=@JoinColumn(name="boo_id"),
	   inverseJoinColumns=@JoinColumn(name="aut_id"))
	private Collection<Book> books = new ArrayList<Book>();

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

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
}
