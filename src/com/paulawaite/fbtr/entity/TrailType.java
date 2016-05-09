package com.paulawaite.fbtr.entity;

import javax.persistence.*;

/**
 * Created by paulawaite on 5/6/16.
 */
@Entity
@Table(name = "trail_type", schema = "FAT_BIKE_TRAIL_REPORTS")
public class TrailType {
    private int id;
    private String name;

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
    @Column(name = "name", nullable = true, length = 50)
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
