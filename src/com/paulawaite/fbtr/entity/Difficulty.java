package com.paulawaite.fbtr.entity;

/**
 * Created by paulawaite on 2/13/16.
 */
public class Difficulty {
    private int id;
    private String name;

    public Difficulty() {
    }

    public Difficulty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Difficulty that = (Difficulty) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Difficulty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
