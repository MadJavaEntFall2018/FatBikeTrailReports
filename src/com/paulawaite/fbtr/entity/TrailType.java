package com.paulawaite.fbtr.entity;

/**
 * Created by paulawaite on 2/13/16.
 */
public class TrailType {
    private int id;
    private String name;

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

        TrailType trailType = (TrailType) o;

        if (id != trailType.id) return false;
        if (name != null ? !name.equals(trailType.name) : trailType.name != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
