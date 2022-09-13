package com.example.apiweb.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_navabar", schema = "web_truyen", catalog = "")
public class RoleNavabarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "role_id")
    private int roleId;
    @Basic
    @Column(name = "navbar_id")
    private int navbarId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getNavbarId() {
        return navbarId;
    }

    public void setNavbarId(int navbarId) {
        this.navbarId = navbarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleNavabarEntity that = (RoleNavabarEntity) o;
        return id == that.id && roleId == that.roleId && navbarId == that.navbarId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, navbarId);
    }
}
