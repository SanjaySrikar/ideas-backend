package com.idea.ideas.dao;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.ideas.dto.User;
import com.idea.ideas.repository.UserRepo;

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

@ContextConfiguration(classes = {UserDAO.class})
@ExtendWith(SpringExtension.class)
class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @MockBean
    private UserRepo userRepo;

    /**
     * Method under test: {@link UserDAO#saveUser(User)}
     */
    @Test
    void testSaveUser() {
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
        when(userRepo.save((User) any())).thenReturn(user);

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
        assertSame(user, userDAO.saveUser(user1));
        verify(userRepo).save((User) any());
    }

    /**
     * Method under test: {@link UserDAO#deleteUser(int)}
     */
    @Test
    void testDeleteUser() {
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
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepo).delete((User) any());
        when(userRepo.findById((Integer) any())).thenReturn(ofResult);
        userDAO.deleteUser(1);
        verify(userRepo).findById((Integer) any());
        verify(userRepo).delete((User) any());
    }

    /**
     * Method under test: {@link UserDAO#deleteUser(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.idea.ideas.dao.UserDAO.deleteUser(UserDAO.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(userRepo).delete((User) any());
        when(userRepo.findById((Integer) any())).thenReturn(null);
        userDAO.deleteUser(1);
    }

    /**
     * Method under test: {@link UserDAO#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepo.findAll()).thenReturn(userList);
        List<User> actualFindAllResult = userDAO.findAll();
        assertSame(userList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(userRepo).findAll();
    }

    /**
     * Method under test: {@link UserDAO#findById(int)}
     */
    @Test
    void testFindById() {
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(user, userDAO.findById(1));
        verify(userRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserDAO#updateUser(User, int)}
     */
    @Test
    void testUpdateUser() {
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepo.save((User) any())).thenReturn(user1);
        when(userRepo.findById((Integer) any())).thenReturn(ofResult);

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
        assertSame(user1, userDAO.updateUser(user2, 1));
        verify(userRepo).save((User) any());
        verify(userRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserDAO#updateUser(User, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.idea.ideas.dao.UserDAO.updateUser(UserDAO.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(userRepo.save((User) any())).thenReturn(user);
        when(userRepo.findById((Integer) any())).thenReturn(null);

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
        userDAO.updateUser(user1, 1);
    }

    /**
     * Method under test: {@link UserDAO#findByUsername(String)}
     */
    @Test
    void testFindByUsername() {
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
        when(userRepo.findByUsername((String) any())).thenReturn(user);
        assertSame(user, userDAO.findByUsername("janedoe"));
        verify(userRepo).findByUsername((String) any());
    }
}

