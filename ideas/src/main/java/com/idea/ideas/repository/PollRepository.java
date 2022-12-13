package com.idea.ideas.repository;

import com.idea.ideas.dto.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> {
    public Poll findByTopic(String topic);
}