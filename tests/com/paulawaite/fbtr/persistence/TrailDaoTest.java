package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 3/6/16.
 */
public class TrailDaoTest {

    private int insertedRecordToBeDeleted = 0;
    TrailDao dao = new TrailDao();
    Trail trail = new Trail();
    //TODO add teardown to remove the inserted record after
    // each test

    @Before
    public void setUp() {
        int insertedTrailId = 0;
        //create trail to add
        Trail trail = new Trail();
        trail.setAddress("100 Main St");
        trail.setCity("Madison");
        trail.setDescription("Trail Description");
        trail.setLength(10);
        trail.setState("WI");
        trail.setZip("53704");
        trail.setName("My Trail");
        trail.setLengthUnits("mi");
        trail.setWebsite("www.trail.com");
        trail.setTrailMap("map link");

        insertedRecordToBeDeleted = dao.addTrail(trail);

    }

    @Test
    public void testGetAllTrails() throws Exception {
        List<Trail> trailList = dao.getAllTrails();
        assertTrue(trailList.size() > 0);
    }

    @Test
    public void testGetTrailById() throws Exception {
        Trail trail = dao.getTrailById(insertedRecordToBeDeleted);
        assertEquals(insertedRecordToBeDeleted, trail.getId());
        assertEquals("mi", trail.getLengthUnits());
    }

    @Test
    public void testAddTrail() throws Exception {




        assertTrue(insertedRecordToBeDeleted > 0);

    }
}