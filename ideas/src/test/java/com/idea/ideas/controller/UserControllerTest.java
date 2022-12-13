package com.idea.ideas.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idea.ideas.dto.Role;
import com.idea.ideas.dto.User;
import com.idea.ideas.service.UserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#login(User)}
     */
    @Test
    void testLogin() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Fname");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Lname");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());
        when(userService.login((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFname("Fname");
        user1.setId(1);
        user1.setIdeas(new ArrayList<>());
        user1.setLname("Lname");
        user1.setPassword("iloveyou");
        user1.setPolls(new ArrayList<>());
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        user1.setVotes(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"fname\":\"Fname\",\"lname\":\"Lname\",\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password"
                                        + "\":\"iloveyou\",\"ideas\":[],\"votes\":[]}"));
    }

    /**
     * Method under test: {@link UserController#get(int)}
     */
    @Test
    void testGet() throws Exception {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        role.setUsers(new ArrayList<>());
        when(userService.getRole(anyInt())).thenReturn(role);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/role/{id}", 1);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"users\":[]}"));
    }

    /**
     * Method under test: {@link UserController#register(User)}
     */
    @Test
    void testRegister() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Fname");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Lname");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());
        when(userService.saveUser((User) any(), anyInt())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFname("Fname");
        user1.setId(1);
        user1.setIdeas(new ArrayList<>());
        user1.setLname("Lname");
        user1.setPassword("iloveyou");
        user1.setPolls(new ArrayList<>());
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        user1.setVotes(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"fname\":\"Fname\",\"lname\":\"Lname\",\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password"
                                        + "\":\"iloveyou\",\"ideas\":[],\"votes\":[]}"));
    }

    /**
     * Method under test: {@link UserController#registerRole(User, int)}
     */
    @Test
    void testRegisterRole() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Fname");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Lname");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());
        when(userService.saveUser((User) any(), anyInt())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFname("Fname");
        user1.setId(1);
        user1.setIdeas(new ArrayList<>());
        user1.setLname("Lname");
        user1.setPassword("iloveyou");
        user1.setPolls(new ArrayList<>());
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        user1.setVotes(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/register/{role}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"fname\":\"Fname\",\"lname\":\"Lname\",\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password"
                                        + "\":\"iloveyou\",\"ideas\":[],\"votes\":[]}"));
    }
}

