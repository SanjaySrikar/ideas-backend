package com.idea.ideas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idea.ideas.dto.Idea;


public interface IdeaRepo extends JpaRepository<Idea,Integer> {

}
