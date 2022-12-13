package com.idea.ideas.dao;

import com.idea.ideas.dto.Vote;
import com.idea.ideas.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoteDAO {
    @Autowired
    VoteRepo repository;

    public Vote saveVote(Vote vote) {
        return repository.save(vote);
    }

    public void deleteRol(int id) {
        Vote vote = repository.findById(id).orElse(null);
        repository.delete(vote);
        return;
    }


    public List<Vote> findAll() {
        return repository.findAll();
    }

    public Vote findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Vote updateRol(Vote Vote, int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
