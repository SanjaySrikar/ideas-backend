package com.idea.ideas.dao;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.repository.PollRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PollDAO.class})
@ExtendWith(SpringExtension.class)
class PollDAOTest {
    @Autowired
    private PollDAO pollDAO;

    @MockBean
    private PollRepository pollRepository;

    /**
     * Method under test: {@link PollDAO#savePoll(Poll)}
     */
    @Test
    void testSavePoll() {
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
        when(pollRepository.save((Poll) any())).thenReturn(poll2);

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(new Poll());

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

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic3);
        poll4.setUsers(new ArrayList<>());
        assertSame(poll2, pollDAO.savePoll(poll4));
        verify(pollRepository).save((Poll) any());
    }

    /**
     * Method under test: {@link PollDAO#deletePoll(int)}
     */
    @Test
    void testDeletePoll() {
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
        Optional<Poll> ofResult = Optional.of(poll1);
        doNothing().when(pollRepository).delete((Poll) any());
        when(pollRepository.findById((Integer) any())).thenReturn(ofResult);
        pollDAO.deletePoll(1);
        verify(pollRepository).findById((Integer) any());
        verify(pollRepository).delete((Poll) any());
    }

    /**
     * Method under test: {@link PollDAO#deletePoll(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePoll2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.idea.ideas.dao.PollDAO.deletePoll(PollDAO.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(pollRepository).delete((Poll) any());
        when(pollRepository.findById((Integer) any())).thenReturn(null);
        pollDAO.deletePoll(1);
    }

    /**
     * Method under test: {@link PollDAO#findByTopic(String)}
     */
    @Test
    void testFindByTopic() {
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
        when(pollRepository.findByTopic((String) any())).thenReturn(poll2);
        assertSame(poll2, pollDAO.findByTopic("Topic"));
        verify(pollRepository).findByTopic((String) any());
    }

    /**
     * Method under test: {@link PollDAO#updatePoll(Poll, int)}
     */
    @Test
    void testUpdatePoll() {
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
        when(pollRepository.save((Poll) any())).thenReturn(poll2);

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(new Poll());

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

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic3);
        poll4.setUsers(new ArrayList<>());
        assertSame(poll2, pollDAO.updatePoll(poll4, 1));
        verify(pollRepository).save((Poll) any());
    }

    /**
     * Method under test: {@link PollDAO#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Poll> pollList = new ArrayList<>();
        when(pollRepository.findAll()).thenReturn(pollList);
        List<Poll> actualFindAllResult = pollDAO.findAll();
        assertSame(pollList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(pollRepository).findAll();
    }

    /**
     * Method under test: {@link PollDAO#findById(int)}
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
        Optional<Poll> ofResult = Optional.of(poll1);
        when(pollRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(poll1, pollDAO.findById(1));
        verify(pollRepository).findById((Integer) any());
    }
}

