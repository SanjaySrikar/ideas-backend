package com.idea.ideas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.TopicDAO;
import com.idea.ideas.dto.Topic;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    TopicDAO dao;

    public ResponseEntity<ResponseStructure<Topic>> saveTopic(Topic topic) {
        Topic find = dao.findByName(topic.getName());
        if (find == null) {
//			dao.saveTopic(topic);
            ResponseStructure<Topic> structure = new ResponseStructure<Topic>();
            structure.setMessage("Topic successfully saved");
            structure.setStatus(HttpStatus.CREATED.value());
            structure.setR(dao.saveTopic(topic));
            return new ResponseEntity<ResponseStructure<Topic>>(structure, HttpStatus.CREATED);
        } else {
            ResponseStructure<Topic> structure = new ResponseStructure<Topic>();
            structure.setMessage("Topic already exists");
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setR(null);
            return new ResponseEntity<ResponseStructure<Topic>>(structure, HttpStatus.CREATED);
        }

    }

    public ResponseEntity<ResponseStructure<Topic>> updateTopic(Topic Topic, int id) {
        ResponseStructure<Topic> structure = new ResponseStructure<Topic>();
        structure.setMessage("Topic successfully updated");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.updateTopic(Topic, id));
        return new ResponseEntity<ResponseStructure<Topic>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteTopic(int id) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setMessage("Topic Successfully Deleted");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.deleteTopic(id));
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
    }

    public Topic findById(int id) {
        return dao.findById(id);
    }

    public List<Topic> findAll() {
        return dao.findAll();
    }

}
