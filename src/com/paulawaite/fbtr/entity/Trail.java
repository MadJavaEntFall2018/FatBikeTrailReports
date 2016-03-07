package com.paulawaite.fbtr.entity;

import java.sql.Date;
/**
 * Created by paulawaite on 2/13/16.
 */
public class Trail {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Integer length;
    private String lengthUnits;
    private String description;
    private String website;
    private String trailMap;
    private int id;
    private Date createDate;
    private Date updateDate;


    private Difficulty difficulty;
    private TrailType type;
    private User user;

    public Trail() {

    }

    public Trail(String name, String address, String city, String state,
                 String zip, Integer length, String lengthUnits, String
                         description, String website, String trailMap, int
                         id, Date createDate, Date updateDate, User user,
                 TrailType type, Difficulty difficulty) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.length = length;
        this.lengthUnits = lengthUnits;
        this.description = description;
        this.website = website;
        this.trailMap = trailMap;
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.difficulty = difficulty;
        this.user = user;
        this.type = type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public TrailType getType() {
        return type;
    }

    public void setType(TrailType type) {
        this.type = type;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
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
        if (createDate != null ? !createDate.equals(trail.createDate) : trail.createDate != null)
            return false;
        if (updateDate != null ? !updateDate.equals(trail.updateDate) : trail.updateDate != null)
            return false;
        if (difficulty != null ? !difficulty.equals(trail.difficulty) : trail.difficulty != null)
            return false;
        if (type != null ? !type.equals(trail.type) : trail.type != null)
            return false;
        return user != null ? user.equals(trail.user) : trail.user == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (lengthUnits != null ? lengthUnits.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (trailMap != null ? trailMap.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", length=" + length +
                ", lengthUnits=" + lengthUnits +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", trailMap='" + trailMap + '\'' +
                ", id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", difficulty=" + difficulty +
                ", type=" + type +
                ", user=" + user +
                '}';
    }


}

