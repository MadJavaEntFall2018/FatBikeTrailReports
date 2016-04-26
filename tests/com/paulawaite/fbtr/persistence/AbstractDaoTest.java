package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class AbstractDaoTest {
    AbstractDao dao;
    Difficulty difficulty;

    @Before
    public void setUp() {
        dao = new AbstractDao(Difficulty.class);
        difficulty = new Difficulty(0, "Pretty Hard");

    }

    @Test
    public void testCreate() throws Exception {
        int createdId = dao.create(difficulty);
        Difficulty difficultyCreated = (Difficulty)dao.get(createdId);
        assertTrue(difficulty.getName().equals(difficultyCreated.getName()));
    }

    @Test
    public void testGet() throws Exception {
        int createdId = dao.create(difficulty);
        Difficulty actualDifficulty = (Difficulty)dao.get(createdId);
        assertNotNull(actualDifficulty);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Difficulty> difficultiesList = dao.getAll();
        assertTrue(difficultiesList.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        int createdId = dao.create(difficulty);
        difficulty.setId(createdId);
        difficulty.setName("Easy");
        dao.update(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.get(createdId);
        assertTrue(updatedDifficulty.getName().equals("Easy"));

    }

    @Test
    public void testDelete() throws Exception {
        int createdId = dao.create(difficulty);
        difficulty.setId(createdId);
        dao.delete(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.get(createdId);
        assertNull(updatedDifficulty);

    }
}