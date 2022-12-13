package com.idea.ideas.controller;

import com.idea.ideas.dto.EmailMessage;
import com.idea.ideas.dto.Role;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dto.User;
import com.idea.ideas.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService user_service;
	@PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
	public User login(@RequestBody User user) throws Exception {
		 User result = user_service.login(user);
         if(result == null){
             throw new Exception("Not correct details");
         }
         return result;

	}

    @GetMapping("/role/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Role get(@PathVariable int id) {
        return user_service.getRole(id);
    }


    @PostMapping("/register/{role}")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerRole(@RequestBody User user , @PathVariable(required = false) int role) {
        return user_service.saveUser(user,role);
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public User register(@RequestBody User user) {
        return user_service.saveUser(user,1);
    }

    // send mail
    @PostMapping("/sendMail/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseStructure<String>> sendMail(@RequestBody EmailMessage emailMessage , @PathVariable int id) {
        return user_service.sendMail(emailMessage,id);
    }

    //get all users
    @GetMapping("get/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> getAllUsers() {
        return user_service.findAll();
    }

}
