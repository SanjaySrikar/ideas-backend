package com.idea.ideas.repository;

import com.idea.ideas.dto.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
}