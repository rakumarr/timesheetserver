package com.ms2003.timesheet.business.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * Created by hr on 28/3/17.
 */
public class EmployeeDTO {

    @Size(min=2, max=30)
    @NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    private String firstName;

    @Size(min=2, max=30)
    @NotNull(message = "Last name is compulsory")
    @NotBlank(message = "Last name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    private String lastName;

    @NotNull(message = "Gender is compulsory")
    private String gender;

    @NotNull(message="Email Address is compulsory")
    @NotBlank(message="Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
    private String email;

    @NotNull(message = "Role is compulsory")
    private String role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
