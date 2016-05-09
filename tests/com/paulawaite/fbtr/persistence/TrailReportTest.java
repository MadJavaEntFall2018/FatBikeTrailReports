package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailReport;
import com.paulawaite.fbtr.entity.Users;
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
    UserDao userDao;
    AbstractDao trailDao;

    TrailReport trailReport;
    Users user;
    Trail trail;

    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        dao = new AbstractDao(TrailReport.class);
        userDao = new UserDao();
        trailDao = new AbstractDao(Trail.class);

        trailReport = new TrailReport();
        trailReport.setComments("test comments");
        trailReport.setTrail(createTrail());
        trailReport.setUser(createUser());
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
        trailReport.setId(createdId);
        trailReport.setConditions("Fast and Firm");
        dao.update(trailReport);
        TrailReport updatedTrailReport = (TrailReport) dao.get(createdId);
        assertTrue(updatedTrailReport.getConditions().equals("Fast and Firm"));

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.create(trailReport);
        trailReport.setId(createdId);
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

    private Users createUser() {

        user = new Users();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setEmailAddress("TrailReportTester@gmail.com");
        user.setPassword("supersecret");
        int createdId = userDao.addUser(user);
        user = (Users)userDao.getUser(createdId);
        log.debug("Created user "+ user );
        return user;
    }

    @After
    public void tearDown() {

        dao.delete(trailReport);
        trailDao.delete(trail);
        userDao.deleteUser(user);
        log.debug("Completed teardown.");

    }
}