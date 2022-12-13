package com.idea.ideas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;







    private String email;
    private String username;
    private String password;

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Idea> ideas = new java.util.ArrayList<>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Poll> polls = new java.util.ArrayList<>();

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "User_role",
            joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn
    private List<Vote> votes = new java.util.ArrayList<>();

    public List<Vote> getVotes() {
        return votes;
    }

    public int getId() {
        return id;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
