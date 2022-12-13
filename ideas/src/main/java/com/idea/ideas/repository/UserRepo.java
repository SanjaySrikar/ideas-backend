package com.idea.ideas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idea.ideas.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
