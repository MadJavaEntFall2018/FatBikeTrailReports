package com.paulawaite.fbtr.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/*
 * Trail's location which can be specified as the physical address or lat/long.
 * @pwaite
 */

@EqualsAndHashCode
@ToString
@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter
    @Setter
    private int locationId;

    @Getter @Setter private String address1;
    @Getter @Setter private String address2;
    @Getter @Setter private String city;
    @Getter @Setter private String state;
    @Getter @Setter private String postalcode;
    @Getter @Setter private String lat;
    @Getter @Setter private String lon;

}
