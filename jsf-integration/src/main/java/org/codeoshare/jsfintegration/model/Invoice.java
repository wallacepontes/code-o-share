package org.codeoshare.jsfintegration.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cos_invoice")
public class Invoice {
	@Id
	@GeneratedValue
	private Long id;
	
	//TODO: @OneToMany (mappedBy="cos_invoice") not worked
	@OneToMany
	@JoinTable(name="cos_invoice_link",
	  joinColumns=@JoinColumn(name="INV_ID"),
	  inverseJoinColumns=@JoinColumn(name="LIN_ID"))
	private Collection<Link> links = new ArrayList<Link>();
	
	@Temporal(TemporalType.DATE)
	private Calendar expiration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Link> getLinks() {
		return links;
	}

	public void setLinks(Collection<Link> links) {
		this.links = links;
	}

	public Calendar getExpiration() {
		return expiration;
	}

	public void setExpiration(Calendar expiration) {
		this.expiration = expiration;
	}

}
