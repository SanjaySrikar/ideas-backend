package com.idea.ideas.repository;

import com.idea.ideas.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}