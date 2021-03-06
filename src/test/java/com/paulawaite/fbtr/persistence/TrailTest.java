package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.test.util.DatabaseUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class TrailTest {
    GenericDao dao;
    Trail trail;
    DatabaseUtility databaseUtility;

    @Before
    public void setUp() {
        dao = new GenericDao(Trail.class);
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");
        trail = new Trail();
        trail.setName("TestTrailName");

    }

    @Test
    public void testCreate() throws Exception {
        int createdId = dao.insert(trail);
        Trail trailCreated = (Trail)dao.getById(createdId);
        assertEquals(trail, trailCreated);
    }

    @Test
    public void testGet() throws Exception {
        int createdId = dao.insert(trail);
        Trail actualTrail = (Trail)dao.getById(createdId);
        assertNotNull(actualTrail);
        assertEquals(trail, actualTrail);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Trail> trailList = dao.getAll();
        assertTrue(trailList.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        int createdId = dao.insert(trail);
        trail.setId(createdId);
        trail.setWebsite("TestWebSite");
        dao.saveOrUpdate(trail);
        Trail updatedTrail = (Trail) dao.getById(createdId);
        assertEquals(trail, updatedTrail);

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.insert(trail);
        trail.setId(createdId);
        dao.delete(trail);
        Trail updatedTrail = (Trail) dao.getById(createdId);
        assertNull(updatedTrail);

    }

    @Test
    public void testSelectWithMultiplePropertiesEqualSuccess() throws Exception {
        Map<String, Object> propsAndValues = new HashMap<>();
        propsAndValues.put("name", "BFL");
        propsAndValues.put("length", 14);
        List<Trail> trails = dao.findByPropertyEqual(propsAndValues);
        assertEquals(2, trails.size());

    }
}