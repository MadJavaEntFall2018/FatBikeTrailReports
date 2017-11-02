package com.paulawaite.fbtr.entity;

import com.paulawaite.fbtr.util.TimestampAttributeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * The user's Role.
 */
@EqualsAndHashCode(exclude = {"createDate", "updateDate"})
@ToString
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "roleId", nullable = false)
    @Getter @Setter private int roleId;

    @Getter @Setter private String name;

    @Convert(converter = TimestampAttributeConverter.class)
    @Getter @Setter private LocalDateTime updateDate;

    @Convert(converter = TimestampAttributeConverter.class)
    @Getter @Setter private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name="userName", referencedColumnName = "username", nullable = false)    // referenceColumnName if not primary key
    @Getter @Setter private User user;

}
