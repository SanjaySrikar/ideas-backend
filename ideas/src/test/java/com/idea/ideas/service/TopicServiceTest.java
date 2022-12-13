package com.idea.ideas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.TopicDAO;
import com.idea.ideas.dto.Poll;
import com.idea.ideas.dto.Topic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TopicService.class})
@ExtendWith(SpringExtension.class)
class TopicServiceTest {
    @MockBean
    private TopicDAO topicDAO;

    @Autowired
    private TopicService topicService;

    /**
     * Method under test: {@link TopicService#saveTopic(Topic)}
     */
    @Test
    void testSaveTopic() {
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

        Topic topic5 = new Topic();
        topic5.setId(1);
        topic5.setIdeas(new ArrayList<>());
        topic5.setName("Name");
        topic5.setPoll(poll3);
        when(topicDAO.findByName((String) any())).thenReturn(topic2);
        when(topicDAO.saveTopic((Topic) any())).thenReturn(topic5);

        Poll poll4 = new Poll();
        poll4.setId(1);
        poll4.setIdeas(new ArrayList<>());
        poll4.setTopic(new Topic());
        poll4.setUsers(new ArrayList<>());

        Topic topic6 = new Topic();
        topic6.setId(1);
        topic6.setIdeas(new ArrayList<>());
        topic6.setName("Name");
        topic6.setPoll(poll4);

        Poll poll5 = new Poll();
        poll5.setId(1);
        poll5.setIdeas(new ArrayList<>());
        poll5.setTopic(topic6);
        poll5.setUsers(new ArrayList<>());

        Topic topic7 = new Topic();
        topic7.setId(1);
        topic7.setIdeas(new ArrayList<>());
        topic7.setName("Name");
        topic7.setPoll(poll5);
        ResponseEntity<ResponseStructure<Topic>> actualSaveTopicResult = topicService.saveTopic(topic7);
        assertTrue(actualSaveTopicResult.hasBody());
        assertTrue(actualSaveTopicResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualSaveTopicResult.getStatusCode());
        ResponseStructure<Topic> body = actualSaveTopicResult.getBody();
        assertEquals(302, body.getStatus());
        assertEquals("Topic already exists", body.getMessage());
        assertNull(body.getR());
        verify(topicDAO).findByName((String) any());
    }

    /**
     * Method under test: {@link TopicService#updateTopic(Topic, int)}
     */
    @Test
    void testUpdateTopic() {
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
        when(topicDAO.updateTopic((Topic) any(), anyInt())).thenReturn(topic2);

        Poll poll2 = new Poll();
        poll2.setId(1);
        poll2.setIdeas(new ArrayList<>());
        poll2.setTopic(new Topic());
        poll2.setUsers(new ArrayList<>());

        Topic topic3 = new Topic();
        topic3.setId(1);
        topic3.setIdeas(new ArrayList<>());
        topic3.setName("Name");
        topic3.setPoll(poll2);

        Poll poll3 = new Poll();
        poll3.setId(1);
        poll3.setIdeas(new ArrayList<>());
        poll3.setTopic(topic3);
        poll3.setUsers(new ArrayList<>());

        Topic topic4 = new Topic();
        topic4.setId(1);
        topic4.setIdeas(new ArrayList<>());
        topic4.setName("Name");
        topic4.setPoll(poll3);
        ResponseEntity<ResponseStructure<Topic>> actualUpdateTopicResult = topicService.updateTopic(topic4, 1);
        assertTrue(actualUpdateTopicResult.hasBody());
        assertTrue(actualUpdateTopicResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateTopicResult.getStatusCode());
        ResponseStructure<Topic> body = actualUpdateTopicResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Topic successfully updated", body.getMessage());
        assertSame(topic2, body.getR());
        verify(topicDAO).updateTopic((Topic) any(), anyInt());
    }

    /**
     * Method under test: {@link TopicService#deleteTopic(int)}
     */
    @Test
    void testDeleteTopic() {
        when(topicDAO.deleteTopic(anyInt())).thenReturn("Delete Topic");
        ResponseEntity<ResponseStructure<String>> actualDeleteTopicResult = topicService.deleteTopic(1);
        assertTrue(actualDeleteTopicResult.hasBody());
        assertTrue(actualDeleteTopicResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeleteTopicResult.getStatusCode());
        ResponseStructure<String> body = actualDeleteTopicResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("Topic Successfully Deleted", body.getMessage());
        assertEquals("Delete Topic", body.getR());
        verify(topicDAO).deleteTopic(anyInt());
    }

    /**
     * Method under test: {@link TopicService#findById(int)}
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

        Topic topic2 = new Topic();
        topic2.setId(1);
        topic2.setIdeas(new ArrayList<>());
        topic2.setName("Name");
        topic2.setPoll(poll1);
        when(topicDAO.findById(anyInt())).thenReturn(topic2);
        assertSame(topic2, topicService.findById(1));
        verify(topicDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link TopicService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Topic> topicList = new ArrayList<>();
        when(topicDAO.findAll()).thenReturn(topicList);
        List<Topic> actualFindAllResult = topicService.findAll();
        assertSame(topicList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(topicDAO).findAll();
    }
}

