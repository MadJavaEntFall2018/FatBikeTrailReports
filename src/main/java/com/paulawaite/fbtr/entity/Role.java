package com.paulawaite.fbtr.entity;

import com.paulawaite.fbtr.util.TimestampAttributeConverter;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * The user's Role.
 */
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String role;

    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude private LocalDateTime updateDate;

    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name="userName", referencedColumnName = "userName", nullable = false)    // referenceColumnName if not primary key
    private User user;

}
