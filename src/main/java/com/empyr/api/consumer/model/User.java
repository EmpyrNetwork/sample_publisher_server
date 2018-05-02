package com.empyr.api.consumer.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String userWhoInvited;
    private String privacyLevel;
    private String phone;
    private String systemGeneratedEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    private double donatePercent;
    private int numAlerts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserWhoInvited() {
        return userWhoInvited;
    }

    public void setUserWhoInvited(String userWhoInvited) {
        this.userWhoInvited = userWhoInvited;
    }

    public double getDonatePercent() {
        return donatePercent;
    }

    public void setDonatePercent(double donatePercent) {
        this.donatePercent = donatePercent;
    }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(String privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public int getNumAlerts() {
        return numAlerts;
    }

    public void setNumAlerts(int numAlerts) {
        this.numAlerts = numAlerts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSystemGeneratedEmail() {
        return systemGeneratedEmail;
    }

    public void setSystemGeneratedEmail(String systemGeneratedEmail) {
        this.systemGeneratedEmail = systemGeneratedEmail;
    }
}