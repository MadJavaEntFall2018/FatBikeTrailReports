package com.paulawaite.fbtr.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * The User.
 */
@EqualsAndHashCode(exclude={"roles", "trails", "trailReports"})
@ToString(exclude={"roles", "trails", "trailReports"})
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "userId", nullable = false)
    @Getter @Setter private int userId;

    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private Timestamp createDate;
    @Getter @Setter private Timestamp updateDate;
    @Getter @Setter private String userName;

    // WARNING: only use EAGER if there will only ever be a very low number of "many" records
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private Set<Role> roles = new HashSet<Role>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Getter @Setter private Set<Trail> trails = new HashSet<Trail>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Getter @Setter private Set<TrailReport> trailReports = new HashSet<TrailReport>();;


    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(Role role) {
        roles.add(role);

    }

}
