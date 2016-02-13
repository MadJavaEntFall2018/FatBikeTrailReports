package com.paulawaite.fbtr.entity;

import java.io.Serializable;

/**
 * Created by paulawaite on 2/13/16.
 */
public class UsersRolesPK implements Serializable {
    private String emailAddress;
    private String role;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

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

        UsersRolesPK that = (UsersRolesPK) o;

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
