package com.bennieslab.portfolio.model;

public class UserPublicDto {

    private String firstName;
    private String lastName;
    private String career;
    private String location;

    public UserPublicDto() {
    }

    public UserPublicDto(String firstName, String lastName, String career, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.career = career;
        this.location = location;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
