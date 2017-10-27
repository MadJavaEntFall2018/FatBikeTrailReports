package com.paulawaite.fbtr.entity;

import javax.persistence.*;

@Entity
public class GroomingType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int groomingTypeId;
    private String grooming;

    public int getGroomingTypeId() {
        return groomingTypeId;
    }

    public void setGroomingTypeId(int groomingTypeId) {
        this.groomingTypeId = groomingTypeId;
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

        if (groomingTypeId != that.groomingTypeId) return false;
        if (grooming != null ? !grooming.equals(that.grooming) : that.grooming != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groomingTypeId;
        result = 31 * result + (grooming != null ? grooming.hashCode() : 0);
        return result;
    }
}
