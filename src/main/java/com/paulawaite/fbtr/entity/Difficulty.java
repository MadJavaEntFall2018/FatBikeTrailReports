package com.paulawaite.fbtr.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The trail Difficulty.
 */
@Data
@Entity
public class Difficulty {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

}
