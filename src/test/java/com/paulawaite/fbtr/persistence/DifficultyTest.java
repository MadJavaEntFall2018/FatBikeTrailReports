package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Difficulty;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class DifficultyTest {
    AbstractDao dao;
    Difficulty difficulty;

    @Before
    public void setUp() {
        dao = new AbstractDao(Difficulty.class);
        difficulty = new Difficulty();
        difficulty.setDifficulty("Pretty Hard");

    }

    @Test
    public void testCreate() throws Exception {
        int createdId = dao.create(difficulty);
        Difficulty difficultyCreated = (Difficulty)dao.get(createdId);
        assertTrue(difficulty.getDifficulty().equals(difficultyCreated.getDifficulty()));
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
        difficulty.setDifficultyId(createdId);
        difficulty.setDifficulty("Easy");
        dao.update(difficulty);
        Difficulty updatedDifficulty = (Difficulty) dao.get(createdId);
        assertTrue(updatedDifficulty.getDifficulty().equals("Easy"));

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