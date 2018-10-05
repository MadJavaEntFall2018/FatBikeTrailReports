package com.paulawaite.fbtr.entity;

import com.paulawaite.fbtr.util.TimestampAttributeConverter;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Trail.
 */
@Data
@Entity
public class Trail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private BigDecimal length;
    private String lengthUnits;
    private String description;
    private String website;
    private String trailMap;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "difficulty")
    private Difficulty difficulty;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private Location location;

    @OneToMany(mappedBy = "trail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TrailReport> reports = new HashSet<TrailReport>() ;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "type")
    private TrailType type;
}
