package com.paulawaite.fbtr.entity;

import javax.persistence.*;

/**
 * Created by paulawaite on 5/6/16.
 */
@Entity
@Table(name = "grooming_type", schema = "FAT_BIKE_TRAIL_REPORTS", catalog = "")
public class GroomingType {
    private int id;
    private String grooming;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "grooming", nullable = true, length = 30)
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
}
