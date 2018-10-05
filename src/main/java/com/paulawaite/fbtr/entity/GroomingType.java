package com.paulawaite.fbtr.entity;

import javax.persistence.*;

import lombok.*;


/**
 * The grooming type.
 */
@Data
@Entity
public class GroomingType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
}
