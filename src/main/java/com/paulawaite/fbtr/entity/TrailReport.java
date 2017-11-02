package com.paulawaite.fbtr.entity;

import com.paulawaite.fbtr.util.TimestampAttributeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Condition report for the trail
 */
@EqualsAndHashCode(exclude = {"createDate", "updateDate"})
@ToString
@Entity
@Table(name="trail_report")
public class TrailReport {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int trailReportId;

    @Convert(converter = TimestampAttributeConverter.class)
    @Getter @Setter private LocalDateTime rideDate;

    @Convert(converter = TimestampAttributeConverter.class)
    @Getter @Setter private LocalDateTime createDate;

    @Convert(converter = TimestampAttributeConverter.class)
    @Getter @Setter private LocalDateTime updateDate;

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
