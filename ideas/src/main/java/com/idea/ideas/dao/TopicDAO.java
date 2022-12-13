package com.idea.ideas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.idea.ideas.dto.Topic;
import com.idea.ideas.repository.TopicRepo;

@Repository
public class TopicDAO {

    @Autowired
    TopicRepo repository;

    public Topic saveTopic(Topic topic) {
        return repository.save(topic);
    }

    public String deleteTopic(int id) {
        Topic topic = repository.findById(id).orElse(null);
        if (topic == null) {
            return "Already Deleted";
        }
        repository.delete(topic);
        return "Topic Deleted ";
    }

    public Topic findByName(String name) {
        return repository.findByName(name);
    }

    public List<Topic> findAll() {
        return repository.findAll();
    }

    public Topic findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Topic updateTopic(Topic topic, int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
