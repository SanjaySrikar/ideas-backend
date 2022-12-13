package com.idea.ideas.controller;

import static org.mockito.Mockito.when;

import com.idea.ideas.dao.VoteDAO;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {VoteController.class})
@ExtendWith(SpringExtension.class)
class VoteControllerTest {
    @Autowired
    private VoteController voteController;

    @MockBean
    private VoteDAO voteDAO;

    /**
     * Method under test: {@link VoteController#getAllVotes()}
     */
    @Test
    void testGetAllVotes() throws Exception {
        when(voteDAO.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vote/get");
        MockMvcBuilders.standaloneSetup(voteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

