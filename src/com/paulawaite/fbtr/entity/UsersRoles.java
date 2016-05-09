package com.paulawaite.fbtr.entity;

import javax.persistence.*;

/**
 * Created by paulawaite on 5/6/16.
 */
@Entity
@Table(name = "users_roles", schema = "FAT_BIKE_TRAIL_REPORTS")
@IdClass(UsersRolesPK.class)
public class UsersRoles {
    private String emailAddress;
    private String role;

    @Id
    @Column(name = "email_address", nullable = false, length = 30)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Id
    @Column(name = "role", nullable = false, length = 30)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersRoles that = (UsersRoles) o;

        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null)
            return false;
        if (role != null ? !role.equals(that.role) : that.role != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailAddress != null ? emailAddress.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
