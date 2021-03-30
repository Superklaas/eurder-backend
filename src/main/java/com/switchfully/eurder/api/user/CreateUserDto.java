package com.switchfully.eurder.api.user;

public class CreateUserDto {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String emailAddress;

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
}
