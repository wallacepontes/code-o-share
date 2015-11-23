package org.codeoshare.jsfintegration.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cos_topic")
public class Topic {
	@Id
	@GeneratedValue
	private Long id;
	
	//orphanRemoval=true to use topico.getComentarios().clear();
	//CascadeType.REMOVE
	@OneToMany(cascade={CascadeType.PERSIST}, orphanRemoval=true)
	@JoinTable(name="cos_topic_comment",
	  joinColumns=@JoinColumn(name="TOP_ID"),
	  inverseJoinColumns=@JoinColumn(name="COM_ID"))
	private List<Comment> comments = new ArrayList<Comment>();
	
	private String Title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
}
