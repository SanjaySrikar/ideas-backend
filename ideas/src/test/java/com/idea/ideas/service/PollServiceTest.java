package com.idea.ideas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.IdeaDAO;
import com.idea.ideas.dao.PollDAO;
import com.idea.ideas.dao.TopicDAO;
import com.idea.ideas.dao.UserDAO;
import com.idea.ideas.dao.VoteDAO;
import com.idea.ideas.dto.Idea;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;
import com.idea.ideas.dto.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PollService.class})
@ExtendWith(SpringExtension.class)
class PollServiceTest {
    @MockBean
    private IdeaDAO ideaDAO;

    @MockBean
    private PollDAO pollDAO;

    @Autowired
    private PollService pollService;

    @MockBean
    private TopicDAO topicDAO;

    @MockBean
    private UserDAO userDAO;

    @MockBean
    private VoteDAO voteDAO;

    /**
     * Method under test: {@link PollService#savePoll(Poll, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePoll() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //       at java.util.Objects.checkIndex(Objects.java:372)
        //       at java.util.ArrayList.get(ArrayList.java:459)
        //       at com.idea.ideas.service.PollService.savePoll(PollService.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(topicDAO.findById(anyInt())).thenReturn(topic2);

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(new Poll());

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic3);
        poll2.setUsers(new ArrayList<>());

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(poll2);

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(topic4);
        poll3.setUsers(new ArrayList<>());
        pollService.savePoll(poll3, 1);
    }

    /**
     * Method under test: {@link PollService#savePoll(Poll, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePoll2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //       at java.util.Objects.checkIndex(Objects.java:372)
        //       at java.util.ArrayList.get(ArrayList.java:459)
        //       at com.idea.ideas.service.PollService.savePoll(PollService.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(topicDAO.findById(anyInt())).thenReturn(topic6);

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
        idea1.setUser(user1);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic9);

        ArrayList<Idea> ideaList = new ArrayList<>();
        ideaList.add(idea1);

        Topic topic10 = new Topic();
        topic10.setId(1);
        topic10.setIdeas(new ArrayList<>());
        topic10.setName("Name");
        topic10.setPoll(new Poll());

        Poll poll9 = new Poll();
        poll9.setId(1);
        poll9.setIdeas(new ArrayList<>());
        poll9.setTopic(topic10);
        poll9.setUsers(new ArrayList<>());

        Topic topic11 = new Topic();
        topic11.setId(1);
        topic11.setIdeas(new ArrayList<>());
        topic11.setName("Name");
        topic11.setPoll(poll9);

        Poll poll10 = new Poll();
        poll10.setId(1);
        poll10.setIdeas(ideaList);
        poll10.setTopic(topic11);
        poll10.setUsers(new ArrayList<>());
        pollService.savePoll(poll10, 1);
    }

    /**
     * Method under test: {@link PollService#updatePoll(Poll, int)}
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
        when(pollDAO.updatePoll((Poll) any(), anyInt())).thenReturn(poll2);

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
        ResponseEntity<ResponseStructure<Poll>> actualUpdatePollResult = pollService.updatePoll(poll4, 1);
        assertTrue(actualUpdatePollResult.hasBody());
        assertTrue(actualUpdatePollResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdatePollResult.getStatusCode());
        ResponseStructure<Poll> body = actualUpdatePollResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Poll successfully updated", body.getMessage());
        assertSame(poll2, body.getR());
        verify(pollDAO).updatePoll((Poll) any(), anyInt());
    }

    /**
     * Method under test: {@link PollService#deletePoll(int)}
     */
    @Test
    void testDeletePoll() {
        doNothing().when(pollDAO).deletePoll(anyInt());
        ResponseEntity<ResponseStructure<String>> actualDeletePollResult = pollService.deletePoll(1);
        assertTrue(actualDeletePollResult.hasBody());
        assertTrue(actualDeletePollResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeletePollResult.getStatusCode());
        ResponseStructure<String> body = actualDeletePollResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Idea successfully deleted", body.getMessage());
        verify(pollDAO).deletePoll(anyInt());
    }

    /**
     * Method under test: {@link PollService#findById(int)}
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
        when(pollDAO.findById(anyInt())).thenReturn(poll2);
        assertSame(poll2, pollService.findById(1));
        verify(pollDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Poll> pollList = new ArrayList<>();
        when(pollDAO.findAll()).thenReturn(pollList);
        List<Poll> actualFindAllResult = pollService.findAll();
        assertSame(pollList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(pollDAO).findAll();
    }

    /**
     * Method under test: {@link PollService#vote(int, int, int)}
     */
    @Test
    void testVote() {
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

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(new Topic());
        poll3.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll3);

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic2);
        poll4.setUsers(new ArrayList<>());

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(new ArrayList<>());
        poll5.setTopic(topic3);
        poll5.setUsers(new ArrayList<>());
        when(pollDAO.savePoll((Poll) any())).thenReturn(poll5);
        when(pollDAO.findById(anyInt())).thenReturn(poll2);

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(new Poll());

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(topic4);
        poll6.setUsers(new ArrayList<>());

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll6);

        Poll poll7 = new Poll();
        poll7.setId(1);
        poll7.setIdeas(new ArrayList<>());
        poll7.setTopic(topic5);
        poll7.setUsers(new ArrayList<>());

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

        Poll poll8 = new Poll();
        poll8.setId(1);
        poll8.setIdeas(new ArrayList<>());
        poll8.setTopic(new Topic());
        poll8.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll8);

        Poll poll9 = new Poll();
        poll9.setId(1);
        poll9.setIdeas(new ArrayList<>());
        poll9.setTopic(topic6);
        poll9.setUsers(new ArrayList<>());

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(poll9);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Idea");
        idea.setName("Name");
        idea.setPoll(poll7);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Topic");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic7);
        when(ideaDAO.findById(anyInt())).thenReturn(idea);

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
        ResponseEntity<ResponseStructure<Poll>> actualVoteResult = pollService.vote(1, 1, 1);
        assertTrue(actualVoteResult.hasBody());
        assertTrue(actualVoteResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualVoteResult.getStatusCode());
        ResponseStructure<Poll> body = actualVoteResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Vote successfully casted", body.getMessage());
        assertSame(poll5, body.getR());
        verify(pollDAO).findById(anyInt());
        verify(pollDAO).savePoll((Poll) any());
        verify(ideaDAO).findById(anyInt());
        verify(userDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#vote(int, int, int)}
     */
    @Test
    void testVote2() {
        Poll poll = new Poll();
        poll.setId(1);
        poll.setIdeas(new ArrayList<>());
        poll.setTopic(new Topic());
        poll.setUsers(new ArrayList<>());

        Topic topic = new Topic();
        topic.setId(1);
        topic.setIdeas(new ArrayList<>());
        topic.setName("Vote successfully casted");
        topic.setPoll(poll);

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(topic);
        poll1.setUsers(new ArrayList<>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Vote successfully casted");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Vote successfully casted");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Vote successfully casted");
        topic1.setPoll(new Poll());

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Vote successfully casted");
        topic2.setPoll(poll2);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Vote successfully casted");
        idea.setName("Vote successfully casted");
        idea.setPoll(poll1);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Vote successfully casted");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic2);

        ArrayList<Idea> ideaList = new ArrayList<>();
        ideaList.add(idea);

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

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic3);
        poll4.setUsers(new ArrayList<>());

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(ideaList);
        poll5.setTopic(topic4);
        poll5.setUsers(new ArrayList<>());

        Poll poll6 = new Poll();
        poll6.setId(1);
        poll6.setIdeas(new ArrayList<>());
        poll6.setTopic(new Topic());
        poll6.setUsers(new ArrayList<>());

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll6);

        Poll poll7 = new Poll();
        poll7.setId(1);
        poll7.setIdeas(new ArrayList<>());
        poll7.setTopic(topic5);
        poll7.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll7);

        Poll poll8 = new Poll();
        poll8.setId(1);
        poll8.setIdeas(new ArrayList<>());
        poll8.setTopic(topic6);
        poll8.setUsers(new ArrayList<>());
        when(pollDAO.savePoll((Poll) any())).thenReturn(poll8);
        when(pollDAO.findById(anyInt())).thenReturn(poll5);

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(new Poll());

        Poll poll9 = new Poll();
        poll9.setId(1);
        poll9.setIdeas(new ArrayList<>());
        poll9.setTopic(topic7);
        poll9.setUsers(new ArrayList<>());

        Topic topic8 = new Topic();
        topic8.setId(1);
        topic8.setIdeas(new ArrayList<>());
        topic8.setName("Name");
        topic8.setPoll(poll9);

        Poll poll10 = new Poll();
        poll10.setId(1);
        poll10.setIdeas(new ArrayList<>());
        poll10.setTopic(topic8);
        poll10.setUsers(new ArrayList<>());

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

        Poll poll11 = new Poll();
        poll11.setId(1);
        poll11.setIdeas(new ArrayList<>());
        poll11.setTopic(new Topic());
        poll11.setUsers(new ArrayList<>());

        Topic topic9 = new Topic();
        topic9.setId(1);
        topic9.setIdeas(new ArrayList<>());
        topic9.setName("Name");
        topic9.setPoll(poll11);

        Poll poll12 = new Poll();
        poll12.setId(1);
        poll12.setIdeas(new ArrayList<>());
        poll12.setTopic(topic9);
        poll12.setUsers(new ArrayList<>());

        Topic topic10 = new Topic();
        topic10.setId(1);
        topic10.setIdeas(new ArrayList<>());
        topic10.setName("Name");
        topic10.setPoll(poll12);

        Idea idea1 = new Idea();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setDownVotes(1);
        idea1.setId(1);
        idea1.setIdea("Idea");
        idea1.setName("Name");
        idea1.setPoll(poll10);
        idea1.setPoll_votes(1);
        idea1.setTitle("Dr");
        idea1.setTopic("Topic");
        idea1.setUpVotes(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea1.setUpdatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        idea1.setUser(user1);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic10);

        Topic topic11 = new Topic();
        topic11.setId(1);
        topic11.setIdeas(new ArrayList<>());
        topic11.setName("Name");
        topic11.setPoll(new Poll());

        Poll poll13 = new Poll();
        poll13.setId(1);
        poll13.setIdeas(new ArrayList<>());
        poll13.setTopic(topic11);
        poll13.setUsers(new ArrayList<>());

        Topic topic12 = new Topic();
        topic12.setId(1);
        topic12.setIdeas(new ArrayList<>());
        topic12.setName("Name");
        topic12.setPoll(poll13);

        Poll poll14 = new Poll();
        poll14.setId(1);
        poll14.setIdeas(new ArrayList<>());
        poll14.setTopic(topic12);
        poll14.setUsers(new ArrayList<>());

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

        Poll poll15 = new Poll();
        poll15.setId(1);
        poll15.setIdeas(new ArrayList<>());
        poll15.setTopic(new Topic());
        poll15.setUsers(new ArrayList<>());

        Topic topic13 = new Topic();
        topic13.setId(1);
        topic13.setIdeas(new ArrayList<>());
        topic13.setName("Name");
        topic13.setPoll(poll15);

        Poll poll16 = new Poll();
        poll16.setId(1);
        poll16.setIdeas(new ArrayList<>());
        poll16.setTopic(topic13);
        poll16.setUsers(new ArrayList<>());

        Topic topic14 = new Topic();
        topic14.setId(1);
        topic14.setIdeas(new ArrayList<>());
        topic14.setName("Name");
        topic14.setPoll(poll16);

        Idea idea2 = new Idea();
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea2.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        idea2.setDownVotes(1);
        idea2.setId(1);
        idea2.setIdea("Idea");
        idea2.setName("Name");
        idea2.setPoll(poll14);
        idea2.setPoll_votes(1);
        idea2.setTitle("Dr");
        idea2.setTopic("Topic");
        idea2.setUpVotes(1);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea2.setUpdatedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        idea2.setUser(user2);
        idea2.setVotes(new ArrayList<>());
        idea2.set_topic(topic14);
        when(ideaDAO.saveIdea((Idea) any())).thenReturn(idea2);
        when(ideaDAO.findById(anyInt())).thenReturn(idea1);

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
        when(userDAO.findById(anyInt())).thenReturn(user3);
        ResponseEntity<ResponseStructure<Poll>> actualVoteResult = pollService.vote(1, 1, 1);
        assertTrue(actualVoteResult.hasBody());
        assertTrue(actualVoteResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualVoteResult.getStatusCode());
        ResponseStructure<Poll> body = actualVoteResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Vote successfully casted", body.getMessage());
        assertSame(poll8, body.getR());
        verify(pollDAO).findById(anyInt());
        verify(pollDAO).savePoll((Poll) any());
        verify(ideaDAO).findById(anyInt());
        verify(ideaDAO).saveIdea((Idea) any());
        verify(userDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#check(int, int)}
     */
    @Test
    void testCheck() {
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
        when(pollDAO.findById(anyInt())).thenReturn(poll2);
        assertFalse(pollService.check(1, 1));
        verify(pollDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#check(int, int)}
     */
    @Test
    void testCheck2() {
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

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(userList);
        when(pollDAO.findById(anyInt())).thenReturn(poll2);
        assertTrue(pollService.check(1, 1));
        verify(pollDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#check(int, int)}
     */
    @Test
    void testCheck3() {
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

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(userList);
        when(pollDAO.findById(anyInt())).thenReturn(poll2);
        assertFalse(pollService.check(1, 123));
        verify(pollDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#deleteUsers(int)}
     */
    @Test
    void testDeleteUsers() {
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
        when(pollDAO.findById(anyInt())).thenReturn(poll2);
        ResponseEntity<ResponseStructure<String>> actualDeleteUsersResult = pollService.deleteUsers(1);
        assertTrue(actualDeleteUsersResult.hasBody());
        assertTrue(actualDeleteUsersResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeleteUsersResult.getStatusCode());
        ResponseStructure<String> body = actualDeleteUsersResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Users successfully deleted", body.getMessage());
        assertNull(body.getR());
        verify(pollDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link PollService#deleteUsers(int)}
     */
    @Test
    void testDeleteUsers2() {
        Poll poll = new Poll();
        poll.setId(1);
        poll.setIdeas(new ArrayList<>());
        poll.setTopic(new Topic());
        poll.setUsers(new ArrayList<>());

        Topic topic = new Topic();
        topic.setId(1);
        topic.setIdeas(new ArrayList<>());
        topic.setName("Users successfully deleted");
        topic.setPoll(poll);

        Poll poll1 = new Poll();
        poll1.setId(1);
        poll1.setIdeas(new ArrayList<>());
        poll1.setTopic(topic);
        poll1.setUsers(new ArrayList<>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Users successfully deleted");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Users successfully deleted");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());

        Topic topic1 = new Topic();
        topic1.setId(1);
        topic1.setIdeas(new ArrayList<>());
        topic1.setName("Users successfully deleted");
        topic1.setPoll(new Poll());

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(topic1);
        poll2.setUsers(new ArrayList<>());

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Users successfully deleted");
        topic2.setPoll(poll2);

        Idea idea = new Idea();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setDownVotes(1);
        idea.setId(1);
        idea.setIdea("Users successfully deleted");
        idea.setName("Users successfully deleted");
        idea.setPoll(poll1);
        idea.setPoll_votes(1);
        idea.setTitle("Dr");
        idea.setTopic("Users successfully deleted");
        idea.setUpVotes(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        idea.setUpdatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        idea.setUser(user);
        idea.setVotes(new ArrayList<>());
        idea.set_topic(topic2);

        ArrayList<Idea> ideaList = new ArrayList<>();
        ideaList.add(idea);

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

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(topic3);
        poll4.setUsers(new ArrayList<>());

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(ideaList);
        poll5.setTopic(topic4);
        poll5.setUsers(new ArrayList<>());
        when(pollDAO.findById(anyInt())).thenReturn(poll5);

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

        Poll poll7 = new Poll();
        poll7.setId(1);
        poll7.setIdeas(new ArrayList<>());
        poll7.setTopic(topic6);
        poll7.setUsers(new ArrayList<>());

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

        Poll poll8 = new Poll();
        poll8.setId(1);
        poll8.setIdeas(new ArrayList<>());
        poll8.setTopic(new Topic());
        poll8.setUsers(new ArrayList<>());

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(poll8);

        Poll poll9 = new Poll();
        poll9.setId(1);
        poll9.setIdeas(new ArrayList<>());
        poll9.setTopic(topic7);
        poll9.setUsers(new ArrayList<>());

        Topic topic8 = new Topic();
        topic8.setId(1);
        topic8.setIdeas(new ArrayList<>());
        topic8.setName("Name");
        topic8.setPoll(poll9);

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
        idea1.setUser(user1);
        idea1.setVotes(new ArrayList<>());
        idea1.set_topic(topic8);
        when(ideaDAO.saveIdea((Idea) any())).thenReturn(idea1);
        ResponseEntity<ResponseStructure<String>> actualDeleteUsersResult = pollService.deleteUsers(1);
        assertTrue(actualDeleteUsersResult.hasBody());
        assertTrue(actualDeleteUsersResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeleteUsersResult.getStatusCode());
        ResponseStructure<String> body = actualDeleteUsersResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Users successfully deleted", body.getMessage());
        assertNull(body.getR());
        verify(pollDAO).findById(anyInt());
        verify(ideaDAO).saveIdea((Idea) any());
    }
}

