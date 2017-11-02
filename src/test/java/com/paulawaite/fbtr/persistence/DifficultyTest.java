package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class DifficultyTest {
    AbstractDao dao;
    Difficulty difficulty;
    DatabaseUtility databaseUtility;

    @Before
    public void setUp() {
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

        dao = new AbstractDao(Difficulty.class);
        difficulty = new Difficulty();
        difficulty.setName("Pretty Hard");


    }

    @Test
    public void testCreateAndGet() throws Exception {
        int createdId = dao.create(difficulty);
        Difficulty difficultyCreated = (Difficulty)dao.get(createdId);
        assertEquals(difficulty, difficultyCreated);
    }


    @Test
    public void testGetAll() throws Exception {
        List<Difficulty> difficultiesList = dao.getAll();
        assertTrue(difficultiesList.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        int createdId = dao.create(difficulty);
        difficulty.setDifficultyId(createdId);
        difficulty.setName("Easy");
        dao.update(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.get(createdId);
        assertTrue(updatedDifficulty.getName().equals("Easy"));

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.create(difficulty);
        difficulty.setDifficultyId(createdId);
        dao.delete(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.get(createdId);
        assertNull(updatedDifficulty);

    }
}