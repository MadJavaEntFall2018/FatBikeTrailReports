package com.paulawaite.fbtr.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
/**
 * Condition report for the trail
 */
@EqualsAndHashCode
@ToString
@Entity
@Table(name="trail_report")
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
    @JoinColumn(name = "grooming") // TrailReport has a foreign key to GroomingType
    @Getter @Setter private GroomingType grooming;

    @ManyToOne
    @JoinColumn(name = "trail", nullable = false)
    @Getter @Setter private Trail trail;

    @ManyToOne
    @JoinColumn(name="user")
    @Getter @Setter private User user;


}
