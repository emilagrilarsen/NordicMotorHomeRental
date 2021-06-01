package com.example.nordicmotorhomerental.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MotorHome{

    @Id
    private int motorHomeID;
    private String brand;
    private String model;
    private int drivenKM;
    private String bedCount;
    private double pricePerDay;

    public MotorHome() {
    }

    public MotorHome(int motorHomeID, String brand, String model, int drivenKM, String bedCount, double pricePerDay) {
        this.motorHomeID = motorHomeID;
        this.brand = brand;
        this.model = model;
        this.drivenKM = drivenKM;
        this.bedCount = bedCount;
        this.pricePerDay = pricePerDay;
    }


    public int getMotorHomeID() {
        return motorHomeID;
    }

    public void setMotorHomeID(int motorHomeID) {
        this.motorHomeID = motorHomeID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDrivenKM() {
        return drivenKM;
    }

    public void setDrivenKM(int drivenKM) {
        this.drivenKM = drivenKM;
    }

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }


    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

}
