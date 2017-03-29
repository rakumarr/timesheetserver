package com.ms2003.timesheet.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hr on 29/3/17.
 */
@Entity
@Table(name="ROLE_INFO")
public class Role implements Serializable{
    @Id
    @Column(name="ROLE_NAME")
    private String roleName;
    @Column(name="ROLE_DESCRIPTION")
    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
