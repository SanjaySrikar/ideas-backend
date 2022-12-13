package com.idea.ideas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.idea.ideas.dto.User;
import com.idea.ideas.repository.UserRepo;

@Repository
public class UserDAO {
	
	@Autowired
	UserRepo repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(int id) {
		User user = repository.findById(id).orElse(null);
		assert user != null;
		repository.delete(user);
		return;
	}

	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(int id) {
		return repository.findById(id).orElse(null);
	}

	public User updateUser(User user, int id) {
		User local = repository.findById(id).orElse(null);
		assert local != null;
		local.setIdeas(user.getIdeas());
		local.setRoles(user.getRoles());
		local.setUsername(user.getUsername());
		local.setPassword(user.getPassword());
		local.setEmail(user.getEmail());
		local.setFname(user.getFname());
		local.setLname(user.getLname());
		local.setVotes(user.getVotes());
		return repository.save(local);
	}


	public User findByUsername(String username) {
		System.out.println(username);
		return repository.findByUsername(username);
	}


}
