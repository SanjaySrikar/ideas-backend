package com.idea.ideas.controller;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dto.Idea;
import com.idea.ideas.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.Quota;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("idea")
public class IdeaController {

    @Autowired
    IdeaService service;

    @PostMapping("/add/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Idea>> create(@RequestBody Idea idea, @PathVariable int id) {
        return service.saveIdea(idea, id);
    }

    //return all ideas
    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Idea> get() {
        return service.findAll();
    }

    //return ideas by id
    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Idea get(@PathVariable int id) {
        return service.findById(id);
    }

    // update idea
    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Idea>> update(@RequestBody Idea idea, @PathVariable int id) {
        return service.updateIdea(idea, id);
    }

    // upvote idea
    @PutMapping("/upVote/{idea_id}/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Idea>> upVote(@PathVariable int idea_id, @PathVariable int id) {
        return service.upVoteIdea(idea_id, id);
    }
    // user has voted
    @GetMapping("/hasVoted/{idea_id}/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean hasVoted(@PathVariable int idea_id, @PathVariable int id) {
        return service.hasVoted(idea_id, id);
    }

    //remove vote by user id
    @PutMapping("/removeVote/{idea_id}/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Idea>> removeVote(@PathVariable int idea_id, @PathVariable int id) {
        return service.removeVote(idea_id, id);
    }

    //delete idea
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int id) {
        return service.deleteIdea(id);
    }


    //get top 3 ideas
    @GetMapping("/get/top3")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Idea> getTop3() {
        return service.getTop3();
    }

    //download an idea
    @GetMapping("/download/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Resource> download(@PathVariable int id) throws IOException {
        return service.downloadIdea(id);
    }

}
