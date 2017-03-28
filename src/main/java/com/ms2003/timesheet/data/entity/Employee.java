package com.ms2003.timesheet.data.entity;

import javax.persistence.*;

/**
 * Created by hr on 28/3/17.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @Column(name="EMP_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
