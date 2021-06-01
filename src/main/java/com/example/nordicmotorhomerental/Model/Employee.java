package com.example.nordicmotorhomerental.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int employeeID;
    private String title;
    private String name;
    private String address;
    private int zipCode;
    private String CPR;

    public Employee() {
    }

    public Employee(int employeeID, String title, String name, String address, int zipCode, String CPR) {
        this.employeeID = employeeID;
        this.title = title;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.CPR = CPR;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }
}
