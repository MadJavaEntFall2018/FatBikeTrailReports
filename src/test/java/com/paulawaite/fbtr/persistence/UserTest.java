package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Role;
import com.paulawaite.fbtr.entity.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserTest {

    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }


    @Test
    public void testAddUser() throws Exception {
        AbstractDao dao = new AbstractDao(User.class);
        int insertedUserId = 0;
        //create user to add
        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setUserName("UnitTester1");
        user.setEmail("UserDaoTester@gmail.com");
        user.setPassword("supersecret");

        Role role = new Role();
        role.setRole("admin");
        role.setUsers(user);

        user.addRole(role);

        insertedUserId = dao.create(user);

        assertTrue(insertedUserId > 0);

        dao.delete(user);


    }
}