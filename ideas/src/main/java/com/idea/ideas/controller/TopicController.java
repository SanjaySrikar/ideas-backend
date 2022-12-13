package com.idea.ideas.controller;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicService service;

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<Topic>> add(@RequestBody Topic topic) {
        return service.saveTopic(topic);
    }

    @DeleteMapping("/remove/{topic_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<String>> remove(@PathVariable int topic_id) {
        return service.deleteTopic(topic_id);
    }

    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Topic> get(){
        return service.findAll();
    }

}
