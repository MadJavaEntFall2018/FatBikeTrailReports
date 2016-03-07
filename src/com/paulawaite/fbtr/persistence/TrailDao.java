package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.User;
import com.paulawaite.fbtr.entity.UsersRoles;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class TrailDao {

    private final Logger log = Logger.getLogger(this.getClass());


    public List<Trail> getAllTrails() {
        List<Trail> trails = new ArrayList<Trail>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        trails = (ArrayList<Trail>)session.createCriteria(Trail.class).list();

        return trails;
    }

    public Trail getTrailById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (Trail)session.get(Trail.class, id);
    }

    public int addTrail(Trail trail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer trailId = null;
        try {
            tx = session.beginTransaction();
            trailId = (Integer) session.save(trail);
            tx.commit();
            log.info("Added trail: " + trail + " with id of: " + trailId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
           log.error(e);
        } finally {
            session.close();
        }
        return trailId;
    }
}
