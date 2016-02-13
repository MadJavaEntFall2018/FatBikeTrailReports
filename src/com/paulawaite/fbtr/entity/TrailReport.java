package com.paulawaite.fbtr.entity;

import java.sql.Date;

/**
 * Created by paulawaite on 2/13/16.
 */
public class TrailReport {
    private int id;
    private Date dateRidden;
    private String conditions;
    private String comments;
    private Date createDate;
    private GroomingType type;
    private Trail trail;
    private User user;

    public TrailReport() {
    }

    public TrailReport(int id, Date dateRidden, String conditions, String comments, Date createDate, GroomingType type, Trail trail, User user) {
        this.id = id;
        this.dateRidden = dateRidden;
        this.conditions = conditions;
        this.comments = comments;
        this.createDate = createDate;
        this.type = type;
        this.trail = trail;
        this.user = user;
    }

    public GroomingType getType() {
        return type;
    }

    public void setType(GroomingType type) {
        this.type = type;
    }

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRidden() {
        return dateRidden;
    }

    public void setDateRidden(Date dateRidden) {
        this.dateRidden = dateRidden;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "TrailReport{" +
                "id=" + id +
                ", dateRidden=" + dateRidden +
                ", conditions='" + conditions + '\'' +
                ", comments='" + comments + '\'' +
                ", createDate=" + createDate +
                ", type=" + type +
                ", trail=" + trail +
                ", user=" + user +
                '}';
    }
}
