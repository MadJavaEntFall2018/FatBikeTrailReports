package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailReport;
import com.paulawaite.fbtr.entity.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class TrailReportTest {
    AbstractDao dao;
    AbstractDao userDao;
    AbstractDao trailDao;

    TrailReport trailReport;
    User user;
    Trail trail;

    private final Logger log = Logger.getLogger(this.getClass());


    @Before
    public void setUp() {
        dao = new AbstractDao(TrailReport.class);
        userDao = new AbstractDao(User.class);
        trailDao = new AbstractDao(Trail.class);

        trailReport = new TrailReport();
        trailReport.setComments("test comments");
        trailReport.setTrailByTrail(createTrail());
        //TODO
        //trailReport.set(createUser());
    }

    @Test
    public void testCreate() throws Exception {
        int createdId = dao.create(trailReport);
        TrailReport trailReportCreated = (TrailReport)dao.get(createdId);
        assertTrue(trailReport.getComments().equals(trailReportCreated.getComments()));
    }

    @Test
    public void testGet() throws Exception {
        int createdId = dao.create(trailReport);
        TrailReport actualTrailReport = (TrailReport)dao.get(createdId);
        assertNotNull(actualTrailReport);
    }

    @Test
    public void testGetAll() throws Exception {
        dao.create(trailReport);
        List<TrailReport> difficultiesList = dao.getAll();
        assertTrue(difficultiesList.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        int createdId = dao.create(trailReport);
        trailReport.setTrailReportId(createdId);
        trailReport.setConditions("Fast and Firm");
        dao.update(trailReport);
        TrailReport updatedTrailReport = (TrailReport) dao.get(createdId);
        assertTrue(updatedTrailReport.getConditions().equals("Fast and Firm"));

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.create(trailReport);
        trailReport.setTrailReportId(createdId);
        dao.delete(trailReport);
        TrailReport updatedTrailReport = (TrailReport) dao.get(createdId);
        assertNull(updatedTrailReport);

    }

    private Trail createTrail() {

        trail = new Trail();
        trail.setName("TestTrailName");
        int createdId = trailDao.create(trail);
        Trail trailCreated = (Trail)trailDao.get(createdId);
        return trail;
    }

    private User createUser() {

        user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setEmail("TrailReportTester@gmail.com");
        user.setPassword("supersecret");
        int createdId = userDao.create(user);
        user = (User)userDao.get(createdId);
        log.debug("Created user "+ user );
        return user;
    }

}