package com.paulawaite.fbtr.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * The trail Difficulty.
 */
@EqualsAndHashCode
@ToString
@Entity
public class Difficulty {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter private int difficultyId;

    @Getter @Setter private String difficulty;
}
