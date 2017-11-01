package com.paulawaite.fbtr.entity;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The grooming type.
 */
@EqualsAndHashCode
@ToString
@Entity
public class GroomingType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int groomingTypeId;

    @Getter @Setter private String grooming;

}
