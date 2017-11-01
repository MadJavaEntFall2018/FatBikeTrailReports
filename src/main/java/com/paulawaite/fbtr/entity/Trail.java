package com.paulawaite.fbtr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The Trail.
 */
@Entity
public class Trail {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int trailId;

    @Getter @Setter private String name;
    @Getter @Setter private Integer location;
    @Getter @Setter private BigDecimal length;
    @Getter @Setter private String lengthUnits;
    @Getter @Setter private String description;
    @Getter @Setter private String website;
    @Getter @Setter private String trailMap;
    @Getter @Setter private Timestamp createDate;
    @Getter @Setter private Timestamp updateDate;

    @ManyToOne
    @JoinColumn(name = "difficulty", referencedColumnName = "difficultyId")
    @Getter @Setter private Difficulty difficulty;
}
