package com.idea.ideas.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.service.PollService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PollController.class})
@ExtendWith(SpringExtension.class)
class PollControllerTest {
    @Autowired
    private PollController pollController;

    @MockBean
    private PollService pollService;

    /**
     * Method under test: {@link PollController#vote(int, int, int)}
     */
    @Test
    void testVote() throws Exception {
        when(pollService.vote(anyInt(), anyInt(), anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/poll/vote/{poll_id}/{idea_id}/{id}",
                1, 1, 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link PollController#check(int, int)}
     */
    @Test
    void testCheck() throws Exception {
        when(pollService.check(anyInt(), anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/poll/check/{poll_id}/{id}", 1, 1);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link PollController#check(int, int)}
     */
    @Test
    void testCheck2() throws Exception {
        when(pollService.check(anyInt(), anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/poll/check/{poll_id}/{id}", 1, 1);
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link PollController#deleteUsers(int)}
     */
    @Test
    void testDeleteUsers() throws Exception {
        when(pollService.deleteUsers(anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/poll/delete/{poll_id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link PollController#createPoll(Poll, int)}
     */
    @Test
    void testCreatePoll() throws Exception {
        when(pollService.savePoll((Poll) any(), anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        Poll poll = new Poll();
        poll.setId(1);
        poll.setIdeas(new ArrayList<>());
        poll.setTopic(new Topic());
        poll.setUsers(new ArrayList<>());

        Topic topic = new Topic();
        topic.setId(1);
        topic.setIdeas(new ArrayList<>());
        topic.setName("Name");
        topic.setPoll(poll);

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(topic);
        poll1.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll1);

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(poll2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/poll/create/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link PollController#getAllPolls()}
     */
    @Test
    void testGetAllPolls() throws Exception {
        when(pollService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/poll/get");
        MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PollController#getAllPolls()}
     */
    @Test
    void testGetAllPolls2() throws Exception {
        when(pollService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/poll/get");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PollController#getPoll(int)}
     */
    @Test
    void testGetPoll() throws Exception {
        Poll poll = new Poll();
        poll.setId(1);
        poll.setIdeas(new ArrayList<>());
        poll.setTopic(new Topic());
        poll.setUsers(new ArrayList<>());

        Topic topic = new Topic();
        topic.setId(1);
        topic.setIdeas(new ArrayList<>());
        topic.setName("Name");
        topic.setPoll(poll);

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(topic);
        poll1.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll1);

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(new ArrayList<>());
        when(pollService.findById(anyInt())).thenReturn(poll2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/poll/get/{id}", 1);
        MockMvcBuilders.standaloneSetup(pollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"ideas\":[],\"users\":[]}"));
    }
}

