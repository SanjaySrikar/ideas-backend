package com.idea.ideas.controller;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("poll")
public class PollController {

    @Autowired
    PollService service;

    @PostMapping("/create/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Poll>> createPoll(@RequestBody Poll poll, @PathVariable int id) {
        return service.savePoll(poll, id);
    }

    // poll_vote for a idea in a poll
    @PutMapping("/vote/{poll_id}/{idea_id}/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Poll>> vote(@PathVariable int poll_id, @PathVariable int idea_id, @PathVariable int id) {
        return service.vote(poll_id, idea_id, id);
    }

    //check if a user voted in a poll
    @GetMapping("/check/{poll_id}/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Boolean check(@PathVariable int poll_id, @PathVariable int id) {
        return service.check(poll_id, id);
    }


    // get all polls
    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Poll> getAllPolls() {
        return service.findAll();
    }

    // delete users of a poll
    @DeleteMapping("/delete/{poll_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<String>> deleteUsers(@PathVariable int poll_id) {
        return service.deleteUsers(poll_id);
    }

    //get poll by id
    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Poll getPoll(@PathVariable int id) {
        return service.findById(id);
    }

    //delete poll by id
    @DeleteMapping("/deletePoll/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<String>> deletePoll(@PathVariable int id) {
        return service.deletePollById(id);
    }


}
