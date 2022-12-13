package com.idea.ideas.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.util.*;
import java.time.*;

import com.idea.ideas.dao.TopicDAO;
import com.idea.ideas.dao.UserDAO;
import com.idea.ideas.dao.VoteDAO;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.dto.User;
import com.idea.ideas.dto.Vote;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.IdeaDAO;
import com.idea.ideas.dto.Idea;


@Service
public class IdeaService {

    @Autowired
    IdeaDAO dao;
    @Autowired
    UserDAO user_dao;
    @Autowired
    TopicDAO topic_dao;

    @Autowired
    VoteDAO voteDAO;

    public ResponseEntity<ResponseStructure<Idea>> saveIdea(Idea idea, int id) {
        User user = user_dao.findById(id);
        if (user == null) {
            return new ResponseEntity<ResponseStructure<Idea>>(new ResponseStructure<Idea>(), HttpStatus.NOT_FOUND);
        }
        // getting topic
        String topic_name = idea.getTopic();
        Topic topic = topic_dao.findByName(topic_name);
        idea.set_topic(topic);
        idea.setName(user.getUsername());
        idea.setCreatedDate(new Date());
        idea.setUser(user);
        List<Idea> ideas = user.getIdeas();
        ideas.add(idea);
//        user_dao.updateUser(user, id);
        ResponseStructure<Idea> structure = new ResponseStructure<Idea>();
        structure.setMessage("Idea successfully saved");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setR(dao.saveIdea(idea));
        return new ResponseEntity<ResponseStructure<Idea>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Idea>> updateIdea(Idea Idea, int id) {
        Idea local = dao.findById(id);
        if (local == null) {
            return new ResponseEntity<ResponseStructure<Idea>>(new ResponseStructure<Idea>(), HttpStatus.NOT_FOUND);
        }
        local.setTopic(Idea.getTopic());
        local.setIdea(Idea.getIdea());
        local.set_topic(Idea.get_topic());
        local.setTitle(Idea.getTitle());
        local.setUpdatedDate(new Date());
        ResponseStructure<Idea> structure = new ResponseStructure<Idea>();
        structure.setMessage("Idea successfully updated");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.saveIdea(local));
        return new ResponseEntity<ResponseStructure<Idea>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteIdea(int id) {
        // create response entity
        ResponseStructure<String> structure = new ResponseStructure<String>();
        structure.setMessage("Idea successfully deleted");
        structure.setStatus(HttpStatus.OK.value());
        dao.deleteIdea(id);
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
    }

    public Idea findById(int id) {
        return dao.findById(id);
    }

    public List<Idea> findAll() {
        return dao.findAll();
    }

    public List<Idea> findByTopic(String topic_name) {
        return dao.findByTopic(topic_name);
    }

    public ResponseEntity<ResponseStructure<Idea>> upVoteIdea(int idea_id, int id) {
        User local = user_dao.findById(id);
        Idea idea = dao.findById(idea_id);
        List<Vote> votes = new ArrayList<>();
        votes = idea.getVotes();
        // for every vote in the list check if the user has voted
        for (Vote vote : votes) {
            if (vote.getUser().getId() == id) {
                return new ResponseEntity<ResponseStructure<Idea>>(new ResponseStructure<Idea>(), HttpStatus.BAD_REQUEST);
            }
        }
        Vote vote = new Vote();

        if (idea == null) {
            return new ResponseEntity<ResponseStructure<Idea>>(new ResponseStructure<Idea>(), HttpStatus.NOT_FOUND);
        }
        if (local == null) {
            return new ResponseEntity<ResponseStructure<Idea>>(new ResponseStructure<Idea>(), HttpStatus.NOT_FOUND);
        }
        vote.setIdea(idea);
        vote.setUser(local);
        vote.setCount(vote.getCount() + 1);
        votes.add(vote);
        voteDAO.saveVote(vote);
        idea.setVotes(votes);
        idea.setUpdatedDate(new Date());
        ResponseStructure<Idea> structure = new ResponseStructure<Idea>();
        structure.setMessage("Idea successfully updated");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.saveIdea(idea));
        return new ResponseEntity<ResponseStructure<Idea>>(structure, HttpStatus.OK);
    }

    public boolean hasVoted(int idea_id, int id) {
        Idea idea = dao.findById(idea_id);
        List<Vote> votes = new ArrayList<>();
        votes = idea.getVotes();
        // for every vote in the list check if the user has voted
        for (Vote vote : votes) {
            if (vote.getUser().getId() == id) {
                return true;
            }
        }
        return false;

    }

    public ResponseEntity<ResponseStructure<Idea>> removeVote(int idea_id, int id) {
        Idea idea = dao.findById(idea_id);
        List<Vote> votes = new ArrayList<>();
        votes = idea.getVotes();
        // for every vote in the list check if the user has voted
        for (Vote vote : votes) {
            if (vote.getUser().getId() == id) {
                votes.remove(vote);
                voteDAO.deleteRol(vote.getId());
                idea.setVotes(votes);
                idea.setUpdatedDate(new Date());
                ResponseStructure<Idea> structure = new ResponseStructure<Idea>();
                structure.setMessage("Idea successfully updated");
                structure.setStatus(HttpStatus.OK.value());
                structure.setR(dao.saveIdea(idea));
                return new ResponseEntity<ResponseStructure<Idea>>(structure, HttpStatus.OK);
            }
        }
        return new ResponseEntity<ResponseStructure<Idea>>(new ResponseStructure<Idea>(), HttpStatus.BAD_REQUEST);
    }

    public List<Idea> getTop3() {
        // get the top three ideas with the most votes.length
        List<Idea> ideas = dao.findAll();
        List<Idea> top3 = new ArrayList<>();
        // sort the list
        ideas.sort(new Comparator<Idea>() {
            @Override
            public int compare(Idea o1, Idea o2) {
                return o2.getVotes().size() - o1.getVotes().size();
            }
        });
        // get the top three
        for (int i = 0; i < 3; i++) {
            top3.add(ideas.get(i));
        }
        return top3;
    }
    private static final String EXTENSION = ".txt";
    private static final String PATH_LOCATION = "C:\\Users\\Admin\\Downloads\\";
    public ResponseEntity<Resource> downloadIdea(int id) throws IOException {
        Idea idea = dao.findById(id);
        if (idea == null) {
            return new ResponseEntity<Resource>(new ByteArrayResource(new byte[0]), HttpStatus.NOT_FOUND);
        }
        File file = new File(PATH_LOCATION + idea.getTitle() + " " +
                " " + EXTENSION);
        if (!file.exists()) {
            file.createNewFile();
        }
        // write the content to the file
        FileWriter writer = new FileWriter(file);
        writer.write(idea.getIdea());
        writer.close();
        // create the resource
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + idea.getTitle() + EXTENSION);
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);


    }
}
