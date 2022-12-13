package com.idea.ideas.service;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.*;
import com.idea.ideas.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollService {
    @Autowired
    PollDAO dao;
    @Autowired
    IdeaDAO ideaDAO;
    @Autowired
    TopicDAO topicDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    VoteDAO voteDAO;

    public ResponseEntity<ResponseStructure<Poll>> savePoll(Poll poll, int topic_id ) {

        // if topic_id is already there in polls.topic then throw error

        Topic topic = topicDAO.findById(topic_id);
        //if topic is found in any of the polls
        if(topic == null){
            return new ResponseEntity<ResponseStructure<Poll>>(new ResponseStructure<Poll>(), HttpStatus.NOT_FOUND);
        }
        // get all polls
        List<Poll> polls = dao.findAll();
        for(Poll p : polls){
            if(p.getTopic().getId() == topic_id){
                return new ResponseEntity<ResponseStructure<Poll>>(new ResponseStructure<Poll>(), HttpStatus.BAD_REQUEST);
            }
        }
        topic.setPoll(poll);
//        topicDAO.saveTopic(topic);
        poll.setTopic(topic);
        Idea idea1 = ideaDAO.findById(poll.getIdeas().get(0).getId());
        Idea idea2 = ideaDAO.findById(poll.getIdeas().get(1).getId());
        List<Idea> ideas = new ArrayList<>();
        ideas.add(idea1);
        ideas.add(idea2);
        poll.setIdeas(ideas);
        idea1.setPoll(poll);
        idea2.setPoll(poll);
//        ideaDAO.saveIdea(idea1);
//        ideaDAO.saveIdea(idea2);
        ResponseStructure<Poll> structure = new ResponseStructure<Poll>();
        structure.setMessage("Poll successfully saved");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setR(dao.savePoll(poll));
        return new ResponseEntity<ResponseStructure<Poll>>(structure, HttpStatus.CREATED);
    }


    public ResponseEntity<ResponseStructure<Poll>> updatePoll(Poll Poll, int id) {
        ResponseStructure<Poll> structure = new ResponseStructure<Poll>();
        structure.setMessage("Poll successfully updated");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.updatePoll(Poll, id));
        return new ResponseEntity<ResponseStructure<Poll>>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deletePoll(int id) {
        ResponseStructure<String> structure = new ResponseStructure<String>();
        structure.setMessage("Idea successfully deleted");
        structure.setStatus(HttpStatus.OK.value());
        dao.deletePoll(id);
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
    }

    public Poll findById(int id) {
        return dao.findById(id);
    }


    public List<Poll> findAll() {
        return dao.findAll();
    }


    public ResponseEntity<ResponseStructure<Poll>> vote(int poll_id, int idea_id, int id) {
        Poll poll = dao.findById(poll_id);
        Idea idea = ideaDAO.findById(idea_id);
        User user = userDAO.findById(id);
        // get poll_votes of ideas in poll and increment them by one and save
//        List<Idea> ideas = poll.getIdeas();
//        for (Idea i : ideas) {
//            if (i.getId() == idea_id) {
//                i.setPoll_votes(i.getPoll_votes() + 1);
//                ideaDAO.updateIdea(i, i.getId());
//            }
//        }
        List<User> users = poll.getUsers();
        //if user already exists in users list, return
        for (User u : users) {
            if (u.getId() == id) {
                ResponseStructure<Poll> structure = new ResponseStructure<Poll>();
                structure.setMessage("User already voted");
                structure.setStatus(HttpStatus.FOUND.value());
                structure.setR(null);
                return new ResponseEntity<ResponseStructure<Poll>>(structure, HttpStatus.FOUND);
            }
        }
        users.add(user);
        List<Poll> polls = user.getPolls();
        polls.add(poll);
        user.setPolls(polls);
        poll.setUsers(users);
        // set poll_votes of this idea in the poll and increment by 1
        List<Idea> ideas = poll.getIdeas();
        for (Idea i : ideas) {
            if (i.getId() == idea_id) {
                i.setPoll_votes(i.getPoll_votes() + 1);
                ideaDAO.saveIdea(i);
            }
        }
        ResponseStructure<Poll> structure = new ResponseStructure<Poll>();
        structure.setMessage("Vote successfully casted");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.savePoll(poll));
        return new ResponseEntity<ResponseStructure<Poll>>(structure, HttpStatus.OK);

    }

    public Boolean check(int poll_id, int id) {
        Poll poll = dao.findById(poll_id);
        List<User> users = poll.getUsers();
        for (User u : users) {
            if (u.getId() == id) {

                return true;
            }
        }

        return false;
    }

    public ResponseEntity<ResponseStructure<String>> deleteUsers(int poll_id) {
        // get poll by id and remove all its users and set poll_votes to 0
        Poll poll = dao.findById(poll_id);
        List<User> users = poll.getUsers();
        users.clear();
        List<Idea> ideas = poll.getIdeas();
        for (Idea i : ideas) {
            i.setPoll_votes(0);
            ideaDAO.saveIdea(i);
        }
        ResponseStructure<String> structure = new ResponseStructure<String>();
        structure.setMessage("Users successfully deleted");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(null);
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

    }

    //delete poll by id
    public ResponseEntity<ResponseStructure<String>> deletePollById(int poll_id) {
        // get poll by id and remove all its users and set poll_votes to 0
        Poll poll = dao.findById(poll_id);
        List<User> users = poll.getUsers();
        users.clear();
        List<Idea> ideas = poll.getIdeas();
        for (Idea i : ideas) {
            i.setPoll_votes(0);
            ideaDAO.saveIdea(i);
        }
        dao.deletePoll(poll_id);
        ResponseStructure<String> structure = new ResponseStructure<String>();
        structure.setMessage("Poll successfully deleted");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(null);
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

    }
}
