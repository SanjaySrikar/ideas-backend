package com.idea.ideas.dao;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.ideas.dto.Idea;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.dto.User;
import com.idea.ideas.dto.Vote;
import com.idea.ideas.repository.VoteRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VoteDAO.class})
@ExtendWith(SpringExtension.class)
class VoteDAOTest {
    @Autowired
    private VoteDAO voteDAO;

    @MockBean
    private VoteRepo voteRepo;

    /**
     * Method under test: {@link VoteDAO#saveVote(Vote)}
     */
    @Test
    void testSaveVote() {
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

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(new Poll());

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll2);

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
        idea.set_topic(topic2);

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

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea);
        vote.setType(1);
        vote.setUser(user1);
        when(voteRepo.save((Vote) any())).thenReturn(vote);

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(new Poll());

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(topic3);
        poll3.setUsers(new ArrayList<>());

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

        Idea idea1 = new Idea();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setDownVotes(1);
        idea1.setId(1);
        idea1.setIdea("Idea");
        idea1.setName("Name");
        idea1.setPoll(poll3);
        idea1.setPoll_votes(1);
        idea1.setTitle("Dr");
        idea1.setTopic("Topic");
        idea1.setUpVotes(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setUpdatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setUser(user2);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic4);

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

        Vote vote1 = new Vote();
        vote1.setCount(3);
        vote1.setId(1);
        vote1.setIdea(idea1);
        vote1.setType(1);
        vote1.setUser(user3);
        assertSame(vote, voteDAO.saveVote(vote1));
        verify(voteRepo).save((Vote) any());
    }

    /**
     * Method under test: {@link VoteDAO#deleteRol(int)}
     */
    @Test
    void testDeleteRol() {
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

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(new Topic());
        poll1.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll1);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic1);

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

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea);
        vote.setType(1);
        vote.setUser(user1);
        Optional<Vote> ofResult = Optional.of(vote);
        when(voteRepo.findById((Integer) any())).thenReturn(ofResult);
        doNothing().when(voteRepo).delete((Vote) any());
        voteDAO.deleteRol(1);
        verify(voteRepo).findById((Integer) any());
        verify(voteRepo).delete((Vote) any());
    }

    /**
     * Method under test: {@link VoteDAO#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Vote> voteList = new ArrayList<>();
        when(voteRepo.findAll()).thenReturn(voteList);
        List<Vote> actualFindAllResult = voteDAO.findAll();
        assertSame(voteList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(voteRepo).findAll();
    }

    /**
     * Method under test: {@link VoteDAO#findById(int)}
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

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(new Topic());
        poll1.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll1);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic1);

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

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea);
        vote.setType(1);
        vote.setUser(user1);
        Optional<Vote> ofResult = Optional.of(vote);
        when(voteRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(vote, voteDAO.findById(1));
        verify(voteRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link VoteDAO#updateRol(Vote, int)}
     */
    @Test
    void testUpdateRol() {
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

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(new Topic());
        poll1.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll1);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic1);

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

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea);
        vote.setType(1);
        vote.setUser(user1);
        assertNull(voteDAO.updateRol(vote, 1));
    }

    /**
     * Method under test: {@link VoteDAO#updateRol(Vote, int)}
     */
    @Test
    void testUpdateRol2() {
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

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(new Topic());
        poll1.setUsers(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Name");
        topic1.setPoll(poll1);

        Idea idea = new Idea();
        idea.setCreatedDate(mock(java.sql.Date.class));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic1);

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

        Vote vote = new Vote();
        vote.setCount(3);
        vote.setId(1);
        vote.setIdea(idea);
        vote.setType(1);
        vote.setUser(user1);
        assertNull(voteDAO.updateRol(vote, 1));
    }
}

