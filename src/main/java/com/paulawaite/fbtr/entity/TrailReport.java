package com.paulawaite.fbtr.entity;

import com.paulawaite.fbtr.util.LocalDateAttributeConverter;
import com.paulawaite.fbtr.util.TimestampAttributeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Condition report for the trail
 */
@Data
@Entity
public class TrailReport {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate rideDate;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    private LocalDateTime updateDate;

    private String conditions;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "grooming") // TrailReport has a foreign key to GroomingType
    private GroomingType grooming;

    @ManyToOne
    @JoinColumn(name = "trail", nullable = false)
    private Trail trail;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;


}
