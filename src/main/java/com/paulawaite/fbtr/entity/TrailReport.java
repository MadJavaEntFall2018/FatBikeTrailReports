package com.paulawaite.fbtr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/**
 * Condition report for the trail
 */
@Entity
public class TrailReport {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int trailReportId;

    @Getter @Setter private String rideDate;
    @Getter @Setter private String createDate;
    @Getter @Setter private String updateDate;
    @Getter @Setter private String conditions;
    @Getter @Setter private String comments;

    @ManyToOne
    @JoinColumn(name = "grooming", referencedColumnName = "groomingTypeId")
    @Getter @Setter private GroomingType grooming;


    @ManyToOne
    @JoinColumn(name = "trail", referencedColumnName = "trailId")
    @Getter @Setter private Trail trail;


}
