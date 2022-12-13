package com.idea.ideas.dao;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.ideas.dto.Idea;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.dto.User;
import com.idea.ideas.repository.IdeaRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {IdeaDAO.class})
@ExtendWith(SpringExtension.class)
class IdeaDAOTest {
    @Autowired
    private IdeaDAO ideaDAO;

    @MockBean
    private IdeaRepo ideaRepo;

    /**
     * Method under test: {@link IdeaDAO#saveIdea(Idea)}
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
        when(ideaRepo.save((Idea) any())).thenReturn(idea);

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

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(new Poll());

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(topic5);
        poll6.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll6);

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
        idea1.set_topic(topic6);
        assertSame(idea, ideaDAO.saveIdea(idea1));
        verify(ideaRepo).save((Idea) any());
    }

    /**
     * Method under test: {@link IdeaDAO#deleteIdea(int)}
     */
    @Test
    void testDeleteIdea() {
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
        Optional<Idea> ofResult = Optional.of(idea);
        doNothing().when(ideaRepo).delete((Idea) any());
        when(ideaRepo.findById((Integer) any())).thenReturn(ofResult);
        ideaDAO.deleteIdea(1);
        verify(ideaRepo).findById((Integer) any());
        verify(ideaRepo).delete((Idea) any());
    }

    /**
     * Method under test: {@link IdeaDAO#deleteIdea(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteIdea2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.idea.ideas.dao.IdeaDAO.deleteIdea(IdeaDAO.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(ideaRepo).delete((Idea) any());
        when(ideaRepo.findById((Integer) any())).thenReturn(null);
        ideaDAO.deleteIdea(1);
    }

    /**
     * Method under test: {@link IdeaDAO#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Idea> ideaList = new ArrayList<>();
        when(ideaRepo.findAll()).thenReturn(ideaList);
        List<Idea> actualFindAllResult = ideaDAO.findAll();
        assertSame(ideaList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(ideaRepo).findAll();
    }

    /**
     * Method under test: {@link IdeaDAO#findById(int)}
     */
    @Test
    void testFindById() {
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
        Optional<Idea> ofResult = Optional.of(idea);
        when(ideaRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(idea, ideaDAO.findById(1));
        verify(ideaRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link IdeaDAO#updateIdea(Idea, int)}
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
        when(ideaRepo.save((Idea) any())).thenReturn(idea);

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

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(new Poll());

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(topic5);
        poll6.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll6);

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
        idea1.set_topic(topic6);
        assertSame(idea, ideaDAO.updateIdea(idea1, 1));
        verify(ideaRepo).save((Idea) any());
    }

    /**
     * Method under test: {@link IdeaDAO#findByTopic(String)}
     */
    @Test
    void testFindByTopic() {
        assertNull(ideaDAO.findByTopic("Topic name"));
    }
}

