package com.idea.ideas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "_topic")
	private List<Idea> ideas = new java.util.ArrayList<>();




	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private Poll poll;

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
