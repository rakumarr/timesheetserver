package com.ms2003.timesheet.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hr on 28/3/17.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @Column(name="EMP_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;
    @Column(name="GENDER")
    private String gender;
    @Column(name="EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "roleName")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
