package com.idea.ideas.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.service.TopicService;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TopicController.class})
@ExtendWith(SpringExtension.class)
class TopicControllerTest {
    @Autowired
    private TopicController topicController;

    @MockBean
    private TopicService topicService;

    /**
     * Method under test: {@link TopicController#add(Topic)}
     */
    @Test
    void testAdd() throws Exception {
        when(topicService.saveTopic((Topic) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        Topic topic = new Topic();
        topic.setId(1);
        topic.setIdeas(new ArrayList<>());
        topic.setName("Name");
        topic.setPoll(new Poll());

        Poll poll = new Poll();
        poll.setId(1);
        poll.setIdeas(new ArrayList<>());
        poll.setTopic(topic);
        poll.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll);

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(topic1);
        poll1.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll1);
        String content = (new ObjectMapper()).writeValueAsString(topic2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/topic/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(topicController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link TopicController#get()}
     */
    @Test
    void testGet() throws Exception {
        when(topicService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topic/get");
        MockMvcBuilders.standaloneSetup(topicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TopicController#get()}
     */
    @Test
    void testGet2() throws Exception {
        when(topicService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/topic/get");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(topicController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TopicController#remove(int)}
     */
    @Test
    void testRemove() throws Exception {
        when(topicService.deleteTopic(anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/topic/remove/{topic_id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(topicController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }
}

