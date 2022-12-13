package com.idea.ideas.dao;

import com.idea.ideas.dto.Idea;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollDAO {

    @Autowired
    PollRepository repository;

   // save , delete and update poll methods returns poll
    public Poll savePoll(Poll poll) {
        return repository.save(poll);
    }

    public void deletePoll(int id) {
        Poll poll = repository.findById(id).orElse(null);
        assert poll != null;
        repository.delete(poll);
        return;
    }

    public Poll findByTopic(String topic) {
        return repository.findByTopic(topic);
    }

    public Poll updatePoll(Poll poll, int id) {
        return repository.save(poll);
    }

    // find all polls
    public List<Poll> findAll() {
        return repository.findAll();
    }

    // find poll by id
    public Poll findById(int id) {
        return repository.findById(id).orElse(null);
    }





}
