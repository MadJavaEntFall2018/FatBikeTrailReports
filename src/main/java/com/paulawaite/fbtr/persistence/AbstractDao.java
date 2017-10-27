package com.paulawaite.fbtr.persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 4/24/16.
 */
public class AbstractDao<T> {

    private Class<T> type;
    private final Logger log = Logger.getLogger(this.getClass());

    public AbstractDao(Class<T> type) {
        this.type = type;
    }

    public int create(T object) {
        
        Transaction transaction = null;
        Integer id = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(object);
            transaction.commit();
            log.debug("Created " + object.getClass().getName() + " with id " +
                    "of: " + id);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error saving  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of " + object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public T get(int id) {
        return (T) getSession().get(type, id);
    }

    public List<T> getAll() {
       return (ArrayList<T>)getSession().createCriteria(type).list();
    }

    public void update(T object) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            log.debug("Updated " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error updating  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back update of " +object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(T object) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            log.debug("Deleted " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error deleting  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back delete of " + object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}