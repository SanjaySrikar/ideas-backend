package com.idea.ideas.service;

import java.util.ArrayList;
import java.util.List;

import com.idea.ideas.dao.RoleDAO;
import com.idea.ideas.dto.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.UserDAO;
import com.idea.ideas.dto.User;
import com.idea.ideas.dto.Role;

@Service
public class UserService {

    @Autowired
    UserDAO dao;
    @Autowired
    RoleDAO role_dao;
    @Autowired
    EmailSenderService emailSenderService;


    public User login(User user) {
        User local = dao.findByUsername(user.getUsername());
        if (local != null) {
            if (local.getPassword().equals(user.getPassword())) {
                return local;
            }
        } else {
            return null;
        }
        return null;
    }


    public User saveUser(User user, int role) {

        if (role == 0) role = 1;
        User local = dao.findByUsername(user.getUsername());

        if (local == null) {
            Role local_role = role_dao.findById(role);
            System.out.println(local_role.getName());
            List<Role> addRole = new ArrayList<>();
            addRole.add(local_role);
            user.setRoles(addRole);
            return dao.saveUser(user);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<User>> updateUser(User User, int id) {
        ResponseStructure<User> structure = new ResponseStructure<User>();
        structure.setMessage("User successfully updated");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(dao.updateUser(User, id));
        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }


    public Role getRole(int id) {
        User user = dao.findById(id);
        List<Role> roles = user.getRoles();
        return roles.get(0);
    }

    public ResponseEntity<ResponseStructure<String>> sendMail(EmailMessage emailMessage , int id) {
        User user = dao.findById(id);
        if(user == null){
            ResponseStructure<String> structure = new ResponseStructure<String>();
            structure.setMessage("User not found");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setR(null);
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
        }
        emailSenderService.sendEmail(user.getEmail() , "New Poll Available Please Cast Your Vote." , emailMessage.getText());
        ResponseStructure<String> structure = new ResponseStructure<String>();
        structure.setMessage("Email sent successfully");
        structure.setStatus(HttpStatus.OK.value());
        structure.setR(null);
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
    }
}
