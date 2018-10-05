package com.paulawaite.fbtr.entity;

import lombok.*;

import javax.persistence.*;

/*
 * Trail's location which can be specified as the physical address or lat/long.
 * @pwaite
 */

@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalcode;
    private String lat;
    private String lon;

}
