package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailReport;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class TrailReportsDao {

    private final Logger log = Logger.getLogger(this.getClass());


    public List<TrailReport> getAllTrailReports() {
        List<TrailReport> trailReports = new ArrayList<TrailReport>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        trailReports = (ArrayList<TrailReport>)session.createCriteria
                (TrailReport
                .class).list();
        return trailReports;
    }

    public TrailReport getTrailReportById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (TrailReport)session.get(TrailReport.class, id);
    }

    public int addTrailReport(TrailReport trailReport) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer trailReportId = null;
        try {
            tx = session.beginTransaction();
            trailReportId = (Integer) session.save(trailReport);
            tx.commit();
            log.info("Added trail report: " + trailReport + " with id of: " +
                    trailReportId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
           log.error(e);
        } finally {
            session.close();
        }
        return trailReportId;
    }
}
