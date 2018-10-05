package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import com.paulawaite.fbtr.test.util.DatabaseUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class DifficultyTest {
    GenericDao dao;
    Difficulty difficulty;
    DatabaseUtility databaseUtility;

    @Before
    public void setUp() {
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

        dao = new GenericDao(Difficulty.class);
        difficulty = new Difficulty();
        difficulty.setName("Pretty Hard");


    }

    @Test
    public void testCreateAndGet() throws Exception {
        int createdId = dao.insert(difficulty);
        Difficulty difficultyCreated = (Difficulty)dao.getById(createdId);
        assertEquals(difficulty, difficultyCreated);
    }


    @Test
    public void testGetAll() throws Exception {
        List<Difficulty> difficultiesList = dao.getAll();
        assertEquals(5, difficultiesList.size());
    }

    @Test
    public void testUpdate() throws Exception {
        int createdId = dao.insert(difficulty);
        difficulty.setId(createdId);
        difficulty.setName("Easy");
        dao.saveOrUpdate(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.getById(createdId);
        assertEquals(difficulty, updatedDifficulty);

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.insert(difficulty);
        difficulty.setId(createdId);
        dao.delete(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.getById(createdId);
        assertNull(updatedDifficulty);

    }
}