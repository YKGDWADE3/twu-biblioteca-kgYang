package com.twu.biblioteca.model;

public class User {
    //name, email address and phone number

    private Integer id;

    private String name;

    private String email;

    private String address;

    private String phoneNumber;

    public User(Integer id, String name, String email, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String printInfo() {
        return "name : " + name + ", email : " + email + ", address : "
                + address + ", phoneNumber : " + phoneNumber + ".\n";
    }


}
