package com.idea.ideas.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String topic;
    private String idea;
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoll_votes() {
        return poll_votes;
    }

    public void setPoll_votes(int poll_votes) {
        this.poll_votes = poll_votes;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    private Date createdDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "poll_id")
    private Poll poll;

    private Date updatedDate;
    private int upVotes;

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private int downVotes;
    private int poll_votes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idea")
    private List<Vote> votes = new java.util.ArrayList<>();
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "topic_id")
    private Topic _topic;

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic get_topic() {
        return _topic;
    }

    public void set_topic(Topic _topic) {
        this._topic = _topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }


}
