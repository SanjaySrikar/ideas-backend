package com.idea.ideas.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.idea.ideas.dto.Topic;

public interface TopicRepo extends JpaRepository<Topic, Integer>{

   public Topic findByName(String name);
}
