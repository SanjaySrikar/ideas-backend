package com.idea.ideas.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idea.ideas.dto.Idea;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.dto.User;
import com.idea.ideas.service.IdeaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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

@ContextConfiguration(classes = {IdeaController.class})
@ExtendWith(SpringExtension.class)
class IdeaControllerTest {
    @Autowired
    private IdeaController ideaController;

    @MockBean
    private IdeaService ideaService;

    /**
     * Method under test: {@link IdeaController#get()}
     */
    @Test
    void testGet() throws Exception {
        when(ideaService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/idea/get");
        MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IdeaController#get()}
     */
    @Test
    void testGet2() throws Exception {
        Poll poll = new Poll();
        poll.setId(1);
        poll.setIdeas(new ArrayList<>());
        poll.setTopic(new Topic());
        poll.setUsers(new ArrayList<>());

        Topic topic = new Topic();
        topic.setId(1);
        topic.setIdeas(new ArrayList<>());
        topic.setName("?");
        topic.setPoll(poll);

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(topic);
        poll1.setUsers(new ArrayList<>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("?");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("?");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("?");
        topic1.setPoll(new Poll());

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("?");
        topic2.setPoll(poll2);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(4);
        idea.setId(1);
        idea.setIdea("?");
        idea.setName("?");
        idea.setPoll(poll1);
        idea.setPoll_votes(4);
        idea.setTitle("Dr");
        idea.setTopic("?");
        idea.setUpVotes(4);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic2);

        ArrayList<Idea> ideaList = new ArrayList<>();
        ideaList.add(idea);
        when(ideaService.findAll()).thenReturn(ideaList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/idea/get");
        MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"title\":\"Dr\",\"topic\":\"?\",\"idea\":\"?\",\"name\":\"?\",\"createdDate\":0,\"updatedDate\":0,\"upVotes\":4,"
                                        + "\"downVotes\":4,\"poll_votes\":4,\"votes\":[]}]"));
    }

    /**
     * Method under test: {@link IdeaController#get(int)}
     */
    @Test
    void testGet3() throws Exception {
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

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(new Topic());
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll2);

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(topic2);
        poll3.setUsers(new ArrayList<>());

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(poll3);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll1);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic3);
        when(ideaService.findById(anyInt())).thenReturn(idea);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/idea/get/{id}", 1);
        MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"title\":\"Dr\",\"topic\":\"Topic\",\"idea\":\"Idea\",\"name\":\"Name\",\"createdDate\":0,\"updatedDate\":0,"
                                        + "\"upVotes\":1,\"downVotes\":1,\"poll_votes\":1,\"votes\":[]}"));
    }

    /**
     * Method under test: {@link IdeaController#hasVoted(int, int)}
     */
    @Test
    void testHasVoted() throws Exception {
        when(ideaService.hasVoted(anyInt(), anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/idea/hasVoted/{idea_id}/{id}", 1, 1);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link IdeaController#hasVoted(int, int)}
     */
    @Test
    void testHasVoted2() throws Exception {
        when(ideaService.hasVoted(anyInt(), anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/idea/hasVoted/{idea_id}/{id}", 1, 1);
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link IdeaController#removeVote(int, int)}
     */
    @Test
    void testRemoveVote() throws Exception {
        when(ideaService.removeVote(anyInt(), anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/idea/removeVote/{idea_id}/{id}", 1,
                1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link IdeaController#create(Idea, int)}
     */
    @Test
    void testCreate() throws Exception {
        when(ideaService.saveIdea((Idea) any(), anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

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

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(new Topic());
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll2);

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(topic2);
        poll3.setUsers(new ArrayList<>());

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(poll3);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll1);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic3);
        String content = (new ObjectMapper()).writeValueAsString(idea);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/idea/add/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(ideaController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link IdeaController#delete(int)}
     */
    @Test
    void testDelete() throws Exception {
        when(ideaService.deleteIdea(anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/idea/delete/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link IdeaController#upVote(int, int)}
     */
    @Test
    void testUpVote() throws Exception {
        when(ideaService.upVoteIdea(anyInt(), anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/idea/upVote/{idea_id}/{id}", 1, 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link IdeaController#update(Idea, int)}
     */
    @Test
    void testUpdate() throws Exception {
        when(ideaService.updateIdea((Idea) any(), anyInt())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

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

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(new Topic());
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll2);

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(topic2);
        poll3.setUsers(new ArrayList<>());

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(poll3);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll1);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic3);
        String content = (new ObjectMapper()).writeValueAsString(idea);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/idea/update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(ideaController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }
}

