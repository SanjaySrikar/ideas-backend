package com.idea.ideas.dao;

import com.idea.ideas.dto.Role;
import com.idea.ideas.dto.User;
import com.idea.ideas.repository.RoleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAO {
    @Autowired
    RoleRepo repository;

    public Role saveRole(Role role) {
        return repository.save(role);
    }

    public void deleteRol(int id) {
        Role role = repository.findById(id).orElse(null);
        repository.delete(role);
        return;
    }

    public Role findByName(String name){
        return repository.findByName(name);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Role updateRol(Role role, int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
