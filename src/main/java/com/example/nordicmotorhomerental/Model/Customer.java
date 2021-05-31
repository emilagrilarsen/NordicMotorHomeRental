package com.example.nordicmotorhomerental.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {
    @Id
    private int customerID;
    private String name;
    private String address;
    private int zipCode;
    private int driversLicense;

    public Customer(){

    }

    public Customer(int customerID, String name, String address, int zipCode, int driversLicense) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.driversLicense = driversLicense;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(int driversLicense) {
        this.driversLicense = driversLicense;
    }
}
