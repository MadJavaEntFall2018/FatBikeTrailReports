package com.paulawaite.fbtr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Trail {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int trailId;
    private String name;
    private Integer location;
    private BigDecimal length;
    private String lengthUnits;
    private String description;
    private String website;
    private String trailMap;
    private Timestamp createDate;
    private Timestamp updateDate;

    @ManyToOne
    @JoinColumn(name = "difficulty", referencedColumnName = "difficultyId")
    private Difficulty difficultyByDifficulty;

    public int getTrailId() {
        return trailId;
    }

    public void setTrailId(int trailId) {
        this.trailId = trailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public String getLengthUnits() {
        return lengthUnits;
    }

    public void setLengthUnits(String lengthUnits) {
        this.lengthUnits = lengthUnits;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    public String getTrailMap() {
        return trailMap;
    }

    public void setTrailMap(String trailMap) {
        this.trailMap = trailMap;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trail trail = (Trail) o;

        if (trailId != trail.trailId) return false;
        if (name != null ? !name.equals(trail.name) : trail.name != null) return false;
        if (location != null ? !location.equals(trail.location) : trail.location != null) return false;
        if (length != null ? !length.equals(trail.length) : trail.length != null) return false;
        if (lengthUnits != null ? !lengthUnits.equals(trail.lengthUnits) : trail.lengthUnits != null) return false;
        if (description != null ? !description.equals(trail.description) : trail.description != null) return false;
        if (website != null ? !website.equals(trail.website) : trail.website != null) return false;
        if (trailMap != null ? !trailMap.equals(trail.trailMap) : trail.trailMap != null) return false;
        if (createDate != null ? !createDate.equals(trail.createDate) : trail.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(trail.updateDate) : trail.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trailId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (lengthUnits != null ? lengthUnits.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (trailMap != null ? trailMap.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }


}
