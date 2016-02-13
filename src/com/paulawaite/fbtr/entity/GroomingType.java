package com.paulawaite.fbtr.entity;

/**
 * Created by paulawaite on 2/13/16.
 */
public class GroomingType {
    private int id;
    private String grooming;

    public GroomingType() {
    }

    public GroomingType(int id, String grooming) {
        this.id = id;
        this.grooming = grooming;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrooming() {
        return grooming;
    }

    public void setGrooming(String grooming) {
        this.grooming = grooming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroomingType that = (GroomingType) o;

        if (id != that.id) return false;
        if (grooming != null ? !grooming.equals(that.grooming) : that.grooming != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (grooming != null ? grooming.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroomingType{" +
                "id=" + id +
                ", grooming='" + grooming + '\'' +
                '}';
    }
}
