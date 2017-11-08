package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailReport;
import com.paulawaite.fbtr.entity.User;
import org.apache.log4j.Logger;
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
    AbstractDao dao;
    AbstractDao userDao;
    AbstractDao trailDao;

    TrailReport trailReport;
    User user;
    Trail trail;

    DatabaseUtility databaseUtility;

    private final Logger log = Logger.getLogger(this.getClass());


    @Before
    public void setUp() {

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

        dao = new AbstractDao(TrailReport.class);
        userDao = new AbstractDao(User.class);
        trailDao = new AbstractDao(Trail.class);

        Trail trail = (Trail)trailDao.getAll().get(0);
        Set<TrailReport> reports = trail.getReports();


        trailReport = new TrailReport();
        trailReport.setComments("test comments");
        trailReport.setTrail(trail);

        trailReport.setUser(((User)userDao.getAll().get(0)));
        //reports.add(trailReport);
        //trail.setReports(reports);

        //trailDao.update(trail);
        int id = dao.create(trailReport);
        trailReport = (TrailReport)dao.get(id);


    }
    @Ignore // foreign key constraint error?
    @Test
    public void testCreate() throws Exception {
        TrailReport trailReportCreated = (TrailReport)dao.get(trailReport.getTrailReportId());
        assertTrue(trailReport.getComments().equals(trailReportCreated.getComments()));
        assertEquals((User)userDao.getAll().get(0), trailReport.getUser());
    }

    //@Ignore // foreign key constraint error? Does not  happen when one test is run at atime
    @Test
    public void testGet() throws Exception {
        TrailReport actualTrailReport = (TrailReport)dao.get(trailReport.getTrailReportId());
        assertNotNull(actualTrailReport);
        assertEquals(trailReport, actualTrailReport);
    }

    @Ignore // foreign key constraint error?
    @Test
    public void testGetAll() throws Exception {
        List<TrailReport> trailReports = dao.getAll();
        assertTrue(trailReports.size() > 0);
    }

    @Ignore // foreign key constraint error?
    @Test
    public void testUpdate() throws Exception {
        trailReport.setTrailReportId(trailReport.getTrailReportId());
        trailReport.setConditions("Fast and Firm");
        dao.update(trailReport);
        TrailReport updatedTrailReport = (TrailReport) dao.get(trailReport.getTrailReportId());
        assertTrue(updatedTrailReport.getConditions().equals("Fast and Firm"));

    }
    @Ignore // foreign key constraint error?
    @Test
    public void testDelete() throws Exception {
        dao.delete(trailReport);
        TrailReport deletedTrailReport = (TrailReport) dao.get(trailReport.getTrailReportId());
        assertNull(deletedTrailReport);

    }



}