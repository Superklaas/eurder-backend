package com.switchfully.eurder.api.user_api;

import com.switchfully.eurder.domain.UserType;

public class UserDto {

    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private UserType userType;

    public String getId() {
        return id;
    }

    public UserDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public UserDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public UserDto setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }
}
