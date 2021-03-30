package com.switchfully.eurder.domain;

import java.util.UUID;

public class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String emailAddress;
    private final UserType userType;

    public User(String firstName, String lastName, String address, String phoneNumber, String emailAddress,
                UserType userType) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public UserType getUserType() {
        return userType;
    }
}
