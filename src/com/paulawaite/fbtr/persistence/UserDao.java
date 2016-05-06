package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import com.paulawaite.fbtr.entity.Users;
import com.paulawaite.fbtr.entity.UsersRoles;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());


    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.createCriteria(Users.class).list();
        return users;
    }

    public void updateUser(Users user) {

    }

    public void deleteUser(Users user) {
        AbstractDao dao = new AbstractDao(Users.class);
        dao.delete(user);
    }

    public int addUser(Users user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            userId = (Integer) session.save(user);
            session.save(createUserRole(user));
            tx.commit();
            log.info("Added user: " + user + " with id of: " + userId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
           log.error(e);
        } finally {
            session.close();
        }
        return userId;
    }

    private UsersRoles createUserRole(Users user) {

        UsersRoles usersRoles = new UsersRoles();
        usersRoles.setEmailAddress(user.getEmailAddress());
        usersRoles.setRole("user");
        return usersRoles;
    }
}
