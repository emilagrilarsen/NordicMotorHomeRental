package com.example.nordicmotorhomerental.Model;

public class Repair implements Price {

    private int repairID;
    private int motorHomeID;
    private String note;
    private int fuelLevelLow;
    private int extraKM;
    private double repairPrice;

    public Repair() {
    }

    public Repair(int repairID,int motorHomeID, String note, int fuelLevelLow, int extraKM, double repairPrice) {
        this.repairID = repairID;
        this.motorHomeID = motorHomeID;
        this.note = note;
        this.fuelLevelLow = fuelLevelLow;
        this.extraKM = extraKM;
        this.repairPrice = repairPrice;
    }

    public int getRepairID() {
        return repairID;
    }

    public void setRepairID(int repairID) {
        this.repairID = repairID;

    }

    public int getMotorHomeID() {
        return motorHomeID;
    }

    public void setMotorHomeID(int motorHomeID) {
        this.motorHomeID = motorHomeID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFuelLevelLow() {
        return fuelLevelLow;
    }

    public void setFuelLevelLow(int fuelLevelLow) {
        this.fuelLevelLow = fuelLevelLow;
    }

    public int getExtraKM() {
        return extraKM;
    }

    public void setExtraKM(int extraKM) {
        this.extraKM = extraKM;
    }

    public double getRepairPrice() {

        return repairPrice;
    }

    public void setRepairPrice(double repairPrice) {
        this.repairPrice = repairPrice;
    }

    public double getPrice() {
        double sum = getRepairPrice();
        if (getFuelLevelLow() == 1) {
            sum += (extraKM + 70);
        } else if(getFuelLevelLow() == 0){
            sum += extraKM;
            return sum;
        }
            return sum;
    }

}
