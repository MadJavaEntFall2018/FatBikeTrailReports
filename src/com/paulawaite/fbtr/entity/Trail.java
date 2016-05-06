package com.paulawaite.fbtr.entity;

import javax.persistence.*;

/**
 * Created by paulawaite on 5/6/16.
 */
@Entity
public class Trail {
    private String name;

    @Basic
    @javax.persistence.Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String city;

    @Basic
    @javax.persistence.Column(name = "city", nullable = true, length = 35)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String state;

    @Basic
    @javax.persistence.Column(name = "state", nullable = true, length = 2)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String zip;

    @Basic
    @javax.persistence.Column(name = "zip", nullable = true, length = 10)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    private Integer difficulty;

    @Basic
    @javax.persistence.Column(name = "difficulty", nullable = true)
    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    private Integer type;

    @Basic
    @javax.persistence.Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private Integer length;

    @Basic
    @javax.persistence.Column(name = "length", nullable = true)
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    private String lengthUnits;

    @Basic
    @javax.persistence.Column(name = "length_units", nullable = true, length = 2)
    public String getLengthUnits() {
        return lengthUnits;
    }

    public void setLengthUnits(String lengthUnits) {
        this.lengthUnits = lengthUnits;
    }

    private String description;

    @Basic
    @javax.persistence.Column(name = "description", nullable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String website;

    @Basic
    @javax.persistence.Column(name = "website", nullable = true, length = 50)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private String trailMap;

    @Basic
    @javax.persistence.Column(name = "trail_map", nullable = true, length = 50)
    public String getTrailMap() {
        return trailMap;
    }

    public void setTrailMap(String trailMap) {
        this.trailMap = trailMap;
    }

    private Integer user;

    @Basic
    @javax.persistence.Column(name = "user", nullable = true)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trail trail = (Trail) o;

        if (id != trail.id) return false;
        if (name != null ? !name.equals(trail.name) : trail.name != null)
            return false;
        if (address != null ? !address.equals(trail.address) : trail.address != null)
            return false;
        if (city != null ? !city.equals(trail.city) : trail.city != null)
            return false;
        if (state != null ? !state.equals(trail.state) : trail.state != null)
            return false;
        if (zip != null ? !zip.equals(trail.zip) : trail.zip != null)
            return false;
        if (difficulty != null ? !difficulty.equals(trail.difficulty) : trail.difficulty != null)
            return false;
        if (type != null ? !type.equals(trail.type) : trail.type != null)
            return false;
        if (length != null ? !length.equals(trail.length) : trail.length != null)
            return false;
        if (lengthUnits != null ? !lengthUnits.equals(trail.lengthUnits) : trail.lengthUnits != null)
            return false;
        if (description != null ? !description.equals(trail.description) : trail.description != null)
            return false;
        if (website != null ? !website.equals(trail.website) : trail.website != null)
            return false;
        if (trailMap != null ? !trailMap.equals(trail.trailMap) : trail.trailMap != null)
            return false;
        if (user != null ? !user.equals(trail.user) : trail.user != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (lengthUnits != null ? lengthUnits.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (trailMap != null ? trailMap.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
