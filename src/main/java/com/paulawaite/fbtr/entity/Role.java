package com.paulawaite.fbtr.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "roleId", nullable = false)
    private int roleId;

    private String role;
    private Timestamp updateDate;
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name="userName")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }


    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (roleId != role1.roleId) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;
        if (updateDate != null ? !updateDate.equals(role1.updateDate) : role1.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(role1.createDate) : role1.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

}
