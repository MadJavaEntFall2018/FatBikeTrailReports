package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.Trail;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class TrailTest {
    AbstractDao dao;
    Trail trail;

    @Before
    public void setUp() {
        dao = new AbstractDao(Trail.class);
        trail = new Trail();
        trail.setName("TestTrailName");

    }

    @Test
    public void testCreate() throws Exception {
        int createdId = dao.create(trail);
        Trail trailCreated = (Trail)dao.get(createdId);
        assertTrue(trail.getName().equals(trailCreated.getName()));
    }

    @Test
    public void testGet() throws Exception {
        int createdId = dao.create(trail);
        Trail actualTrail = (Trail)dao.get(createdId);
        assertNotNull(actualTrail);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Trail> difficultiesList = dao.getAll();
        assertTrue(difficultiesList.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        int createdId = dao.create(trail);
        trail.setTrailId(createdId);
        trail.setWebsite("TestWebSite");
        dao.update(trail);
        Trail updatedTrail = (Trail) dao.get(createdId);
        assertTrue(updatedTrail.getWebsite().equals("TestWebSite"));

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.create(trail);
        trail.setTrailId(createdId);
        dao.delete(trail);
        Trail updatedTrail = (Trail) dao.get(createdId);
        assertNull(updatedTrail);

    }
}