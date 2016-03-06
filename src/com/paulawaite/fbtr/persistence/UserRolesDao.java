package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.User;
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
public class UserRolesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public void addUserRole(UsersRoles usersRoles) {
        
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {

            session.save(usersRoles);

            log.info("Added userRole: " + usersRoles);
        } finally {
            session.close();
        }
    }
}
