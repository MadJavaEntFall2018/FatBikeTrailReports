package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.User;
import org.junit.Test;

import javax.ejb.TransactionAttribute;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDaoWithHibernateTest {

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
        UserDaoWithHibernate dao = new UserDaoWithHibernate();
        int insertedUserId = 0;
        //create user to add
        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setEmailAddress("UnitTester@gmail.com");
        user.setPassword("supersecret");
        user.setId(0);

        insertedUserId = dao.addUser(user);

        assertTrue(insertedUserId > 0);


    }
}