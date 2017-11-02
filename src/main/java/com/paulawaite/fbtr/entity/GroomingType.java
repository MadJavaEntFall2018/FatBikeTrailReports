package com.paulawaite.fbtr.entity;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * The grooming type.
 */
@EqualsAndHashCode
@ToString
@Entity
@Table(name="grooming_type")
public class GroomingType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int groomingTypeId;

    @Getter @Setter private String name;
}
