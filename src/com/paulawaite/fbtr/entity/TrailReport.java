package com.paulawaite.fbtr.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by paulawaite on 5/6/16.
 */
@Entity
@Table(name = "trail_report", schema = "FAT_BIKE_TRAIL_REPORTS")
public class TrailReport {
    private int id;
    private Date dateRidden;
    private Integer groomingType;
    private String conditions;
    private String comments;
    private Trail trail;
    private Users user;

    @ManyToOne
    @JoinColumn(name="user", nullable = false)
    public Users getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name="trail", nullable = false)
    public Trail getTrail() {
        return trail;
    }



    public void setUser(Users user) {
        this.user = user;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }


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
    @Column(name = "date_ridden", nullable = true)
    public Date getDateRidden() {
        return dateRidden;
    }

    public void setDateRidden(Date dateRidden) {
        this.dateRidden = dateRidden;
    }

    @Basic
    @Column(name = "grooming_type", nullable = true)
    public Integer getGroomingType() {
        return groomingType;
    }

    public void setGroomingType(Integer groomingType) {
        this.groomingType = groomingType;
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

        if (id != that.id) return false;
        if (dateRidden != null ? !dateRidden.equals(that.dateRidden) : that.dateRidden != null)
            return false;
        if (groomingType != null ? !groomingType.equals(that.groomingType) : that.groomingType != null)
            return false;
        if (conditions != null ? !conditions.equals(that.conditions) : that.conditions != null)
            return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null)
            return false;
        if (user != null ? !user.equals(that.user) : that.user != null)
            return false;
        if (trail != null ? !trail.equals(that.trail) : that.trail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateRidden != null ? dateRidden.hashCode() : 0);
        result = 31 * result + (groomingType != null ? groomingType.hashCode() : 0);
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (trail != null ? trail.hashCode() : 0);
        return result;
    }
}
