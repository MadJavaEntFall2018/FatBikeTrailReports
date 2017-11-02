package com.paulawaite.fbtr.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * The trail type.
 */

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "trail_type")
public class TrailType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int trailTypeId;

    @Getter @Setter private String name;


}
