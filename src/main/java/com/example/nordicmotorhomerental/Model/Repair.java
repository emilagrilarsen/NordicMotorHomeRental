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

    public Repair(int repairID, String note, int fuelLevelLow, int extraKM, double repairPrice) {
        this.repairID = repairID;
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

        return getPrice();
    }

    public void setRepairPrice  (double repairPrice) {
        this.repairPrice = repairPrice;
    }

    public double getPrice(){
        double sum = repairPrice;
        if(getFuelLevelLow() == 0) {
            sum += getExtraKM();
            return sum;
        }else if(getFuelLevelLow() == 1){
            sum += getExtraKM() + 70;
            return sum;
        }
        return sum;

    }
}
