package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailReport;
import com.paulawaite.fbtr.entity.User;
import com.paulawaite.fbtr.test.util.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */

//TODO
// The foreight key constraint errors seem to be caused by: 2017-11-02 17:03:31,136 5907 [main] ERROR com.paulawaite.fbtr.persistence.AbstractDao  - Error updating  Trail(trailId=34, name=BFL, location=null, length=null, lengthUnits=null, description=Big Fat Loop, website=null, trailMap=null, createDate=2017-11-02T17:03:25, updateDate=2017-11-02T17:03:25, difficulty=Difficulty(difficultyId=62, name=Hard), user=User(userId=176, firstName=Unit0, lastName=Test0, email=UserDaoTester@gmail.com0, password=supersecret0, createDate=2017-11-02T17:03:25, updateDate=2017-11-02T17:03:25, userName=UnitTester0), type=TrailType(trailTypeId=30, name=SingleTrack))
//org.hibernate.ObjectNotFoundException: No row with the given identifier exists: [com.paulawaite.fbtr.entity.Difficulty#62]

public class TrailReportTest {
    GenericDao dao;
    GenericDao userDao;
    GenericDao trailDao;

    TrailReport trailReport;
    User user;
    Trail trail;

    DatabaseUtility databaseUtility;

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Before
    public void setUp() {

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

        dao = new GenericDao(TrailReport.class);
        userDao = new GenericDao(User.class);
        trailDao = new GenericDao(Trail.class);

        Trail trail = (Trail)trailDao.getAll().get(0);
        Set<TrailReport> reports = trail.getReports();


        trailReport = new TrailReport();
        trailReport.setComments("test comments");
        trailReport.setTrail(trail);

        trailReport.setUser(((User)userDao.getAll().get(0)));

        int id = dao.insert(trailReport);
        trailReport = (TrailReport)dao.getById(id);


    }
    @Test
    public void testCreate() throws Exception {
        TrailReport trailReportCreated = (TrailReport)dao.getById(trailReport.getId());
        assertTrue(trailReport.getComments().equals(trailReportCreated.getComments()));
        assertEquals((User)userDao.getAll().get(0), trailReport.getUser());
    }


    @Test
    public void testGet() throws Exception {
        TrailReport actualTrailReport = (TrailReport)dao.getById(trailReport.getId());
        assertNotNull(actualTrailReport);
        assertEquals(trailReport, actualTrailReport);
    }

    @Test
    public void testGetAll() throws Exception {
        List<TrailReport> trailReports = dao.getAll();
        assertTrue(trailReports.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        trailReport.setId(trailReport.getId());
        trailReport.setConditions("Fast and Firm");
        dao.saveOrUpdate(trailReport);
        TrailReport updatedTrailReport = (TrailReport) dao.getById(trailReport.getId());
        assertEquals(trailReport, updatedTrailReport );

    }
    @Test
    public void testDelete() throws Exception {
        dao.delete(trailReport);
        TrailReport deletedTrailReport = (TrailReport) dao.getById(trailReport.getId());
        assertNull(deletedTrailReport);

    }



}