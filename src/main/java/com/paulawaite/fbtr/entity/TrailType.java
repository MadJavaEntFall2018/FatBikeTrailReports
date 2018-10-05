package com.paulawaite.fbtr.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The trail type.
 */

@Data
@Entity
public class TrailType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;


}
