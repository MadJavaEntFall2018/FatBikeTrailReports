package com.paulawaite.fbtr.entity;

import javax.persistence.*;

@Entity
public class Difficulty {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int difficultyId;
    private String difficulty;

    public int getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(int difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Difficulty that = (Difficulty) o;

        if (difficultyId != that.difficultyId) return false;
        if (difficulty != null ? !difficulty.equals(that.difficulty) : that.difficulty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = difficultyId;
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        return result;
    }
}
