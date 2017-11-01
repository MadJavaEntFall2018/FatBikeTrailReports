package com.paulawaite.fbtr.entity;

import javax.persistence.*;

@Entity
public class TrailReport {
    private int trailReportId;
    private String rideDate;
    private String createDate;
    private String updateDate;
    private String conditions;
    private String comments;
    private Trail trailByTrail;
    private GroomingType groomingTypeByGrooming;

    @Id
    @Column(name = "trailReportId", nullable = false)
    public int getTrailReportId() {
        return trailReportId;
    }

    public void setTrailReportId(int trailReportId) {
        this.trailReportId = trailReportId;
    }

    @Basic
    @Column(name = "rideDate", nullable = true, length = 45)
    public String getRideDate() {
        return rideDate;
    }

    public void setRideDate(String rideDate) {
        this.rideDate = rideDate;
    }

    @Basic
    @Column(name = "createDate", length = 45)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "updateDate", length = 45)
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "conditions", nullable = true, length = 1000)
    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 1000)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrailReport that = (TrailReport) o;

        if (trailReportId != that.trailReportId) return false;
        if (rideDate != null ? !rideDate.equals(that.rideDate) : that.rideDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (conditions != null ? !conditions.equals(that.conditions) : that.conditions != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trailReportId;
        result = 31 * result + (rideDate != null ? rideDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "trail", referencedColumnName = "trailId")
    public Trail getTrailByTrail() {
        return trailByTrail;
    }

    public void setTrailByTrail(Trail trailByTrail) {
        this.trailByTrail = trailByTrail;
    }

    @ManyToOne
    @JoinColumn(name = "grooming", referencedColumnName = "groomingTypeId")
    public GroomingType getGroomingTypeByGrooming() {
        return groomingTypeByGrooming;
    }

    public void setGroomingTypeByGrooming(GroomingType groomingTypeByGrooming) {
        this.groomingTypeByGrooming = groomingTypeByGrooming;
    }
}
