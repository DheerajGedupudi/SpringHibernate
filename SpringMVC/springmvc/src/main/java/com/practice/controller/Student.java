package com.practice.controller;

import java.util.HashMap;
import java.util.Map;

public class Student
{
    private String firstName;
    private String lastName;

    private String country;

    private Map<String, String> countryOptions;

    private String programmingLanguage;

    private String[] regularLanguages;

    public Student()
    {
        countryOptions = new HashMap<>();

        countryOptions.put("IN", "India");
        countryOptions.put("US", "USA");
        countryOptions.put("FR", "France");
        countryOptions.put("AU", "Australia");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String[] getRegularLanguages() {
        return regularLanguages;
    }

    public void setRegularLanguages(String[] regularLanguages) {
        this.regularLanguages = regularLanguages;
    }
}
