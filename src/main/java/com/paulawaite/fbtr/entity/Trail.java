package com.paulawaite.fbtr.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Trail.
 */
@ToString(exclude = "reports")
@EqualsAndHashCode(exclude = "reports")
@Entity
@Table(name = "trail")
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
    @JoinColumn(name = "difficulty")
    @Getter @Setter private Difficulty difficulty;

    @OneToMany(mappedBy = "trail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter private Set<TrailReport> reports = new HashSet<TrailReport>() ;

    @ManyToOne
    @JoinColumn(name = "user")
    @Getter @Setter private User user;

    @ManyToOne
    @JoinColumn(name = "type")
    @Getter @Setter private TrailType type;
}
