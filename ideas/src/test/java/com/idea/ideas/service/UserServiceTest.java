package com.idea.ideas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.idea.idea.util.ResponseStructure;
import com.idea.ideas.dao.RoleDAO;
import com.idea.ideas.dao.UserDAO;
import com.idea.ideas.dto.Role;
import com.idea.ideas.dto.User;

import java.util.ArrayList;
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

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private RoleDAO roleDAO;

    @MockBean
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#login(User)}
     */
    @Test
    void testLogin() {
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
        when(userDAO.findByUsername((String) any())).thenReturn(user);

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
        assertSame(user, userService.login(user1));
        verify(userDAO).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#login(User)}
     */
    @Test
    void testLogin2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Fname");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Lname");
        user.setPassword("Password");
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());
        when(userDAO.findByUsername((String) any())).thenReturn(user);

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
        assertNull(userService.login(user1));
        verify(userDAO).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#login(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.idea.ideas.service.UserService.login(UserService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Fname");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Lname");
        user.setPassword(null);
        user.setPolls(new ArrayList<>());
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());
        when(userDAO.findByUsername((String) any())).thenReturn(user);

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
        userService.login(user1);
    }

    /**
     * Method under test: {@link UserService#saveUser(User, int)}
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
        when(userDAO.findByUsername((String) any())).thenReturn(user);

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
        assertNull(userService.saveUser(user1, 1));
        verify(userDAO).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#saveUser(User, int)}
     */
    @Test
    void testSaveUser2() {
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
        when(userDAO.findByUsername((String) any())).thenReturn(user);

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
        assertNull(userService.saveUser(user1, 0));
        verify(userDAO).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(User, int)}
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
        when(userDAO.updateUser((User) any(), anyInt())).thenReturn(user);

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
        ResponseEntity<ResponseStructure<User>> actualUpdateUserResult = userService.updateUser(user1, 1);
        assertTrue(actualUpdateUserResult.hasBody());
        assertTrue(actualUpdateUserResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateUserResult.getStatusCode());
        ResponseStructure<User> body = actualUpdateUserResult.getBody();
        assertEquals(200, body.getStatus());
        assertEquals("User successfully updated", body.getMessage());
        assertSame(user, body.getR());
        verify(userDAO).updateUser((User) any(), anyInt());
    }

    /**
     * Method under test: {@link UserService#deleteUser(int)}
     */
    @Test
    void testDeleteUser() {
        doNothing().when(userDAO).deleteUser(anyInt());
        userService.deleteUser(1);
        verify(userDAO).deleteUser(anyInt());
    }

    /**
     * Method under test: {@link UserService#findById(int)}
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
        when(userDAO.findById(anyInt())).thenReturn(user);
        assertSame(user, userService.findById(1));
        verify(userDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link UserService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<User> userList = new ArrayList<>();
        when(userDAO.findAll()).thenReturn(userList);
        List<User> actualFindAllResult = userService.findAll();
        assertSame(userList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(userDAO).findAll();
    }

    /**
     * Method under test: {@link UserService#getRole(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetRole() {
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
        //       at com.idea.ideas.service.UserService.getRole(UserService.java:79)
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
        when(userDAO.findById(anyInt())).thenReturn(user);
        userService.getRole(1);
    }

    /**
     * Method under test: {@link UserService#getRole(int)}
     */
    @Test
    void testGetRole2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        role.setUsers(new ArrayList<>());

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFname("Fname");
        user.setId(1);
        user.setIdeas(new ArrayList<>());
        user.setLname("Lname");
        user.setPassword("iloveyou");
        user.setPolls(new ArrayList<>());
        user.setRoles(roleList);
        user.setUsername("janedoe");
        user.setVotes(new ArrayList<>());
        when(userDAO.findById(anyInt())).thenReturn(user);
        assertSame(role, userService.getRole(1));
        verify(userDAO).findById(anyInt());
    }
}

