package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Users;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDaoTest {

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
        UserDao dao = new UserDao();
        int insertedUserId = 0;
        //create user to add
        Users user = new Users();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setEmailAddress("UserDaoTester@gmail.com");
        user.setPassword("supersecret");

        insertedUserId = dao.addUser(user);

        assertTrue(insertedUserId > 0);
        dao.deleteUser(user);


    }
}