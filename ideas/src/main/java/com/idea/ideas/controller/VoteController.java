package com.idea.ideas.controller;

import com.idea.ideas.dao.VoteDAO;
import com.idea.ideas.dto.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vote")
public class VoteController {
    @Autowired
    VoteDAO dao;

    // get all votes
    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Vote> getAllVotes() {
        return dao.findAll();
    }

}
