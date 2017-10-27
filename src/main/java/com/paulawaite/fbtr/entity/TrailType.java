package com.paulawaite.fbtr.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrailType {
    private int trailTypeId;
    private String trailType;

    @Id
    @Column(name = "trailTypeId", nullable = false)
    public int getTrailTypeId() {
        return trailTypeId;
    }

    public void setTrailTypeId(int trailTypeId) {
        this.trailTypeId = trailTypeId;
    }

    @Basic
    @Column(name = "trailType", nullable = true, length = 45)
    public String getTrailType() {
        return trailType;
    }

    public void setTrailType(String trailType) {
        this.trailType = trailType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrailType trailType1 = (TrailType) o;

        if (trailTypeId != trailType1.trailTypeId) return false;
        if (trailType != null ? !trailType.equals(trailType1.trailType) : trailType1.trailType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trailTypeId;
        result = 31 * result + (trailType != null ? trailType.hashCode() : 0);
        return result;
    }
}
