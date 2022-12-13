package com.idea.ideas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.idea.ideas.dto.Idea;
import com.idea.ideas.repository.IdeaRepo;



@Repository
public class IdeaDAO {
	
	@Autowired
	IdeaRepo repository;
	public Idea saveIdea(Idea idea) {
		return repository.save(idea);
	}



	public void deleteIdea(int id) {
		Idea idea = repository.findById(id).orElse(null);
		assert idea != null;
		repository.delete(idea);
		return;
	}

	
	public List<Idea> findAll() {
		return repository.findAll();
	}
	
	public Idea findById(int id) {
		return repository.findById(id).orElse(null);
		
}

	public Idea updateIdea(Idea idea, int id) {
		return repository.save(idea);
	}

	public List<Idea> findByTopic(String topic_name) {
		// TODO Auto-generated method stub
		return null;
	}
}





