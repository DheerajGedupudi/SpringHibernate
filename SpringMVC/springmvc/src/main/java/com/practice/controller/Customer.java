package com.practice.controller;


import com.practice.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer
{
    private String firstName;

    @NotNull(message = "is Required")
    @Size(min = 1, message="is Required")
    private String lastName;


    @NotNull(message = "is Required")
    @Min(value=1, message="must be greater than 0")
    @Max(value=99, message="must be less than 100")
    private Integer numberCheck;

    @Pattern(regexp = "^([0-9]){6}", message = "has to be 6 digit number")
    private String pinCode;

    @CourseCode(value = "XYZ", message = "must start with XYZ")
    private String courseCode;

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

    public Integer getNumberCheck() {
        return numberCheck;
    }

    public void setNumberCheck(Integer numberCheck) {
        this.numberCheck = numberCheck;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
