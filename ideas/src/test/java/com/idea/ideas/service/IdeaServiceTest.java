package com.idea.ideas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.IdeaDAO;
import com.idea.ideas.dao.TopicDAO;
import com.idea.ideas.dao.UserDAO;
import com.idea.ideas.dao.VoteDAO;
import com.idea.ideas.dto.Idea;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.dto.User;
import com.idea.ideas.dto.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {IdeaService.class})
@ExtendWith(SpringExtension.class)
class IdeaServiceTest {
    @MockBean
    private IdeaDAO ideaDAO;

    @Autowired
    private IdeaService ideaService;

    @MockBean
    private TopicDAO topicDAO;

    @MockBean
    private UserDAO userDAO;

    @MockBean
    private VoteDAO voteDAO;

    /**
     * Method under test: {@link IdeaService#saveIdea(Idea, int)}
     */
    @Test
    void testSaveIdea() {
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
        when(ideaDAO.saveIdea((Idea) any())).thenReturn(idea);

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(new Poll());

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic4);
        poll4.setUsers(new ArrayList<>());

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(new ArrayList<>());
        poll5.setTopic(topic5);
        poll5.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll5);
        when(topicDAO.findByName((String) any())).thenReturn(topic6);

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
        when(userDAO.findById(anyInt())).thenReturn(user1);

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(new Topic());
        poll6.setUsers(new ArrayList<>());

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(poll6);

        Poll poll7 = new Poll();
        poll7.setId(1);
        poll7.setIdeas(new ArrayList<>());
        poll7.setTopic(topic7);
        poll7.setUsers(new ArrayList<>());

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFname("Fname");
        user2.setId(1);
        user2.setIdeas(new ArrayList<>());
        user2.setLname("Lname");
        user2.setPassword("iloveyou");
        user2.setPolls(new ArrayList<>());
        user2.setRoles(new ArrayList<>());
        user2.setUsername("janedoe");
        user2.setVotes(new ArrayList<>());

        Topic topic8 = new Topic();
        topic8.setId(1);
        topic8.setIdeas(new ArrayList<>());
        topic8.setName("Name");
        topic8.setPoll(new Poll());

        Poll poll8 = new Poll();
        poll8.setId(1);
        poll8.setIdeas(new ArrayList<>());
        poll8.setTopic(topic8);
        poll8.setUsers(new ArrayList<>());

        Topic topic9 = new Topic();
        topic9.setId(1);
        topic9.setIdeas(new ArrayList<>());
        topic9.setName("Name");
        topic9.setPoll(poll8);

        Idea idea1 = new Idea();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setDownVotes(1);
        idea1.setId(1);
        idea1.setIdea("Idea");
        idea1.setName("Name");
        idea1.setPoll(poll7);
        idea1.setPoll_votes(1);
        idea1.setTitle("Dr");
        idea1.setTopic("Topic");
        idea1.setUpVotes(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setUpdatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setUser(user2);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic9);
        ResponseEntity<ResponseStructure<Idea>> actualSaveIdeaResult = ideaService.saveIdea(idea1, 1);
        assertTrue(actualSaveIdeaResult.hasBody());
        assertTrue(actualSaveIdeaResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualSaveIdeaResult.getStatusCode());
        ResponseStructure<Idea> body = actualSaveIdeaResult.getBody();
        assertEquals(201, body.getStatus());
        assertEquals("Idea successfully saved", body.getMessage());
        assertSame(idea, body.getR());
        verify(ideaDAO).saveIdea((Idea) any());
        verify(topicDAO).findByName((String) any());
        verify(userDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link IdeaService#updateIdea(Idea, int)}
     */
    @Test
    void testUpdateIdea() {
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

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(new Poll());

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic4);
        poll4.setUsers(new ArrayList<>());

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(new ArrayList<>());
        poll5.setTopic(topic5);
        poll5.setUsers(new ArrayList<>());

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

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(new Topic());
        poll6.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll6);

        Poll poll7 = new Poll();
        poll7.setId(1);
        poll7.setIdeas(new ArrayList<>());
        poll7.setTopic(topic6);
        poll7.setUsers(new ArrayList<>());

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(poll7);

        Idea idea1 = new Idea();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setDownVotes(1);
        idea1.setId(1);
        idea1.setIdea("Idea");
        idea1.setName("Name");
        idea1.setPoll(poll5);
        idea1.setPoll_votes(1);
        idea1.setTitle("Dr");
        idea1.setTopic("Topic");
        idea1.setUpVotes(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setUpdatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setUser(user1);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic7);
        when(ideaDAO.saveIdea((Idea) any())).thenReturn(idea1);
        when(ideaDAO.findById(anyInt())).thenReturn(idea);

        Poll poll8 = new Poll();
        poll8.setId(1);
        poll8.setIdeas(new ArrayList<>());
        poll8.setTopic(new Topic());
        poll8.setUsers(new ArrayList<>());

        Topic topic8 = new Topic();
        topic8.setId(1);
        topic8.setIdeas(new ArrayList<>());
        topic8.setName("Name");
        topic8.setPoll(poll8);

        Poll poll9 = new Poll();
        poll9.setId(1);
        poll9.setIdeas(new ArrayList<>());
        poll9.setTopic(topic8);
        poll9.setUsers(new ArrayList<>());

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFname("Fname");
        user2.setId(1);
        user2.setIdeas(new ArrayList<>());
        user2.setLname("Lname");
        user2.setPassword("iloveyou");
        user2.setPolls(new ArrayList<>());
        user2.setRoles(new ArrayList<>());
        user2.setUsername("janedoe");
        user2.setVotes(new ArrayList<>());

        Topic topic9 = new Topic();
        topic9.setId(1);
        topic9.setIdeas(new ArrayList<>());
        topic9.setName("Name");
        topic9.setPoll(new Poll());

        Poll poll10 = new Poll();
        poll10.setId(1);
        poll10.setIdeas(new ArrayList<>());
        poll10.setTopic(topic9);
        poll10.setUsers(new ArrayList<>());

        Topic topic10 = new Topic();
        topic10.setId(1);
        topic10.setIdeas(new ArrayList<>());
        topic10.setName("Name");
        topic10.setPoll(poll10);

        Idea idea2 = new Idea();
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea2.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        idea2.setDownVotes(1);
        idea2.setId(1);
        idea2.setIdea("Idea");
        idea2.setName("Name");
        idea2.setPoll(poll9);
        idea2.setPoll_votes(1);
        idea2.setTitle("Dr");
        idea2.setTopic("Topic");
        idea2.setUpVotes(1);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea2.setUpdatedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        idea2.setUser(user2);
        idea2.setVotes(new ArrayList<>());
        idea2.set_topic(topic10);
        ResponseEntity<ResponseStructure<Idea>> actualUpdateIdeaResult = ideaService.updateIdea(idea2, 1);
        assertTrue(actualUpdateIdeaResult.hasBody());
        assertTrue(actualUpdateIdeaResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateIdeaResult.getStatusCode());
        ResponseStructure<Idea> body = actualUpdateIdeaResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Idea successfully updated", body.getMessage());
        assertSame(idea1, body.getR());
        verify(ideaDAO).findById(anyInt());
        verify(ideaDAO).saveIdea((Idea) any());
    }

    /**
     * Method under test: {@link IdeaService#deleteIdea(int)}
     */
    @Test
    void testDeleteIdea() {
        doNothing().when(ideaDAO).deleteIdea(anyInt());
        ResponseEntity<ResponseStructure<String>> actualDeleteIdeaResult = ideaService.deleteIdea(1);
        assertTrue(actualDeleteIdeaResult.hasBody());
        assertTrue(actualDeleteIdeaResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeleteIdeaResult.getStatusCode());
        ResponseStructure<String> body = actualDeleteIdeaResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Idea successfully deleted", body.getMessage());
        verify(ideaDAO).deleteIdea(anyInt());
    }

    /**
     * Method under test: {@link IdeaService#findById(int)}
     */
    @Test
    void testFindById() {
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
        when(ideaDAO.findById(anyInt())).thenReturn(idea);
        assertSame(idea, ideaService.findById(1));
        verify(ideaDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link IdeaService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Idea> ideaList = new ArrayList<>();
        when(ideaDAO.findAll()).thenReturn(ideaList);
        List<Idea> actualFindAllResult = ideaService.findAll();
        assertSame(ideaList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(ideaDAO).findAll();
    }

    /**
     * Method under test: {@link IdeaService#findByTopic(String)}
     */
    @Test
    void testFindByTopic() {
        ArrayList<Idea> ideaList = new ArrayList<>();
        when(ideaDAO.findByTopic((String) any())).thenReturn(ideaList);
        List<Idea> actualFindByTopicResult = ideaService.findByTopic("Topic name");
        assertSame(ideaList, actualFindByTopicResult);
        assertTrue(actualFindByTopicResult.isEmpty());
        verify(ideaDAO).findByTopic((String) any());
    }

    /**
     * Method under test: {@link IdeaService#upVoteIdea(int, int)}
     */
    @Test
    void testUpVoteIdea() {
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

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(new Poll());

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic4);
        poll4.setUsers(new ArrayList<>());

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(new ArrayList<>());
        poll5.setTopic(topic5);
        poll5.setUsers(new ArrayList<>());

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

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(new Topic());
        poll6.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll6);

        Poll poll7 = new Poll();
        poll7.setId(1);
        poll7.setIdeas(new ArrayList<>());
        poll7.setTopic(topic6);
        poll7.setUsers(new ArrayList<>());

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(poll7);

        Idea idea1 = new Idea();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setDownVotes(1);
        idea1.setId(1);
        idea1.setIdea("Idea");
        idea1.setName("Name");
        idea1.setPoll(poll5);
        idea1.setPoll_votes(1);
        idea1.setTitle("Dr");
        idea1.setTopic("Topic");
        idea1.setUpVotes(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setUpdatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setUser(user1);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic7);
        when(ideaDAO.saveIdea((Idea) any())).thenReturn(idea1);
        when(ideaDAO.findById(anyInt())).thenReturn(idea);

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFname("Fname");
        user2.setId(1);
        user2.setIdeas(new ArrayList<>());
        user2.setLname("Lname");
        user2.setPassword("iloveyou");
        user2.setPolls(new ArrayList<>());
        user2.setRoles(new ArrayList<>());
        user2.setUsername("janedoe");
        user2.setVotes(new ArrayList<>());
        when(userDAO.findById(anyInt())).thenReturn(user2);

        Poll poll8 = new Poll();
        poll8.setId(1);
        poll8.setIdeas(new ArrayList<>());
        poll8.setTopic(new Topic());
        poll8.setUsers(new ArrayList<>());

        Topic topic8 = new Topic();
        topic8.setId(1);
        topic8.setIdeas(new ArrayList<>());
        topic8.setName("Name");
        topic8.setPoll(poll8);

        Poll poll9 = new Poll();
        poll9.setId(1);
        poll9.setIdeas(new ArrayList<>());
        poll9.setTopic(topic8);
        poll9.setUsers(new ArrayList<>());

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setFname("Fname");
        user3.setId(1);
        user3.setIdeas(new ArrayList<>());
        user3.setLname("Lname");
        user3.setPassword("iloveyou");
        user3.setPolls(new ArrayList<>());
        user3.setRoles(new ArrayList<>());
        user3.setUsername("janedoe");
        user3.setVotes(new ArrayList<>());

        Topic topic9 = new Topic();
        topic9.setId(1);
        topic9.setIdeas(new ArrayList<>());
        topic9.setName("Name");
        topic9.setPoll(new Poll());

        Poll poll10 = new Poll();
        poll10.setId(1);
        poll10.setIdeas(new ArrayList<>());
        poll10.setTopic(topic9);
        poll10.setUsers(new ArrayList<>());

        Topic topic10 = new Topic();
        topic10.setId(1);
        topic10.setIdeas(new ArrayList<>());
        topic10.setName("Name");
        topic10.setPoll(poll10);

        Idea idea2 = new Idea();
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea2.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        idea2.setDownVotes(1);
        idea2.setId(1);
        idea2.setIdea("Idea");
        idea2.setName("Name");
        idea2.setPoll(poll9);
        idea2.setPoll_votes(1);
        idea2.setTitle("Dr");
        idea2.setTopic("Topic");
        idea2.setUpVotes(1);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea2.setUpdatedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        idea2.setUser(user3);
        idea2.setVotes(new ArrayList<>());
        idea2.set_topic(topic10);

        User user4 = new User();
        user4.setEmail("jane.doe@example.org");
        user4.setFname("Fname");
        user4.setId(1);
        user4.setIdeas(new ArrayList<>());
        user4.setLname("Lname");
        user4.setPassword("iloveyou");
        user4.setPolls(new ArrayList<>());
        user4.setRoles(new ArrayList<>());
        user4.setUsername("janedoe");
        user4.setVotes(new ArrayList<>());

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea2);
        vote.setType(1);
        vote.setUser(user4);
        when(voteDAO.saveVote((Vote) any())).thenReturn(vote);
        ResponseEntity<ResponseStructure<Idea>> actualUpVoteIdeaResult = ideaService.upVoteIdea(1, 1);
        assertTrue(actualUpVoteIdeaResult.hasBody());
        assertTrue(actualUpVoteIdeaResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpVoteIdeaResult.getStatusCode());
        ResponseStructure<Idea> body = actualUpVoteIdeaResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Idea successfully updated", body.getMessage());
        assertSame(idea1, body.getR());
        verify(ideaDAO).findById(anyInt());
        verify(ideaDAO).saveIdea((Idea) any());
        verify(userDAO).findById(anyInt());
        verify(voteDAO).saveVote((Vote) any());
    }

    /**
     * Method under test: {@link IdeaService#hasVoted(int, int)}
     */
    @Test
    void testHasVoted() {
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
        when(ideaDAO.findById(anyInt())).thenReturn(idea);
        assertFalse(ideaService.hasVoted(1, 1));
        verify(ideaDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link IdeaService#hasVoted(int, int)}
     */
    @Test
    void testHasVoted2() {
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

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(new Poll());

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic2);
        poll2.setUsers(new ArrayList<>());

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

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(new Topic());
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
        idea.setPoll(poll2);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user1);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic3);

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFname("Fname");
        user2.setId(1);
        user2.setIdeas(new ArrayList<>());
        user2.setLname("Lname");
        user2.setPassword("iloveyou");
        user2.setPolls(new ArrayList<>());
        user2.setRoles(new ArrayList<>());
        user2.setUsername("janedoe");
        user2.setVotes(new ArrayList<>());

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea);
        vote.setType(1);
        vote.setUser(user2);

        ArrayList<Vote> voteList = new ArrayList<>();
        voteList.add(vote);

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(new Topic());
        poll4.setUsers(new ArrayList<>());

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(new ArrayList<>());
        poll5.setTopic(topic4);
        poll5.setUsers(new ArrayList<>());

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll5);

        Idea idea1 = new Idea();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setDownVotes(1);
        idea1.setId(1);
        idea1.setIdea("Idea");
        idea1.setName("Name");
        idea1.setPoll(poll1);
        idea1.setPoll_votes(1);
        idea1.setTitle("Dr");
        idea1.setTopic("Topic");
        idea1.setUpVotes(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setUpdatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setUser(user);
        idea1.setVotes(voteList);
        idea1.set_topic(topic5);
        when(ideaDAO.findById(anyInt())).thenReturn(idea1);
        assertTrue(ideaService.hasVoted(1, 1));
        verify(ideaDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link IdeaService#removeVote(int, int)}
     */
    @Test
    void testRemoveVote() {
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
        when(ideaDAO.findById(anyInt())).thenReturn(idea);
        ResponseEntity<ResponseStructure<Idea>> actualRemoveVoteResult = ideaService.removeVote(1, 1);
        assertTrue(actualRemoveVoteResult.hasBody());
        assertTrue(actualRemoveVoteResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualRemoveVoteResult.getStatusCode());
        verify(ideaDAO).findById(anyInt());
    }
}

