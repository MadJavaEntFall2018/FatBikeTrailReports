package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Role;
import com.paulawaite.fbtr.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserTest {

    AbstractDao dao = null;

    @Before
    public void setUp() {
        dao = new AbstractDao(User.class);
    }


    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = dao.getAll();
        assertTrue(users.size() > 0);
        assertFalse(users.get(0).getFirstName().equals(""));

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = (User) dao.get(1);
        String updateValue = LocalDate.now().toString();
        String emailBeforeUpdate = user.getEmail();
        // it would be a good idea to test each value like this

        user.setEmail(user.getEmail() + updateValue);

        dao.update(user);

        User updatedUser = (User) dao.get(1);

        assertEquals(emailBeforeUpdate + updateValue, updatedUser.getEmail());

    }

    @Test
    public void testDeleteUser() throws Exception {

    }


    @Test
    public void testAddUser() throws Exception {

        int insertedUserId = 0;

        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setUserName("UnitTesterB");
        user.setEmail("UserDaoTesterB@gmail.com");
        user.setPassword("supersecret");

        Role role = new Role();
        role.setRole("admin");
        role.setUsers(user);

        user.addRole(role);

        insertedUserId = dao.create(user);
        User retrievedUser = (User) dao.get(insertedUserId);

        assertTrue(insertedUserId > 0);
        assertEquals(user, retrievedUser);
        assertEquals(retrievedUser.getRoles().size(), 1);
        assertTrue(retrievedUser.getRoles().contains(role));

    }

    public User createTestUser() {

        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setUserName("UnitTesterA");
        user.setEmail("UserDaoTesterA@gmail.com");
        user.setPassword("supersecret");

        Role role = new Role();
        role.setRole("admin");
        role.setUsers(user);

        user.addRole(role);

        return user;
    }
}