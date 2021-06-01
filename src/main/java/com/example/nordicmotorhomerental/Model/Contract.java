package com.example.nordicmotorhomerental.Model;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


@Entity
public class Contract implements Price{

    @Id
    private int contractID;
    private int employeeID;
    private int customerID;
    private int motorHomeID;
    private int extraEquipment;
    private int pickUpKM;
    private int dropOffKM;
    private double totalPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private int season;
    private boolean cancel;

    public Contract() {
    }

    public Contract(int contractID, int employeeID, int customerID, int motorHomeID, int extraEquipment,
                    int pickUpKM, int dropOffKM, LocalDate startDate, LocalDate endDate, int season, boolean cancel) {
        this.contractID = contractID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.motorHomeID = motorHomeID;
        this.extraEquipment = extraEquipment;
        this.pickUpKM = pickUpKM;
        this.dropOffKM = dropOffKM;
        this.startDate = startDate;
        this.endDate = endDate;
        this.season = season;
        this.cancel = cancel;
    }


    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getMotorHomeID() {
        return motorHomeID;
    }

    public void setMotorHomeID(int motorHomeID) {
        this.motorHomeID = motorHomeID;
    }

    public int getExtraEquipment() {
        return extraEquipment;
    }

    public void setExtraEquipment(int extraEquipment) {
        this.extraEquipment = extraEquipment;
    }

    public int getPickUpKM() {
        return pickUpKM;
    }

    public void setPickUpKM(int pickUpKM) {
        this.pickUpKM = pickUpKM;
    }

    public int getDropOffKM() {
        return dropOffKM;
    }

    public void setDropOffKM(int dropOffKM) {
        this.dropOffKM = dropOffKM;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        if(season < 0 || season > 2) {
            throw new IllegalArgumentException("Season must be 0 = low, 1 = middle or 2 = peak");
        }else{
            this.season = season;
        }

    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public double getTotalPrice(double m) {
        double sum = 0.0;
        long noOfDays = ChronoUnit.DAYS.between(getStartDate(), getEndDate());

        if (getSeason() == 0) {
            sum = (m * noOfDays) + getPrice() + (getExtraEquipment() * 40);
            sum = Math.round(sum * 100.0);
            sum = sum / 100;
            return sum;
        } else if (getSeason() == 1) {
            sum = ((m * 1.3) * noOfDays) + getPrice() + (getExtraEquipment() * 40);
            sum = (double) Math.round((sum * 100.0));
            System.out.println(m);
            System.out.println(noOfDays);
            System.out.println(getPrice());
            System.out.println(getExtraEquipment());
            sum = sum / 100;
            return sum;
        } else if (getSeason() == 2){
            sum = ((m * 1.6) * noOfDays) + getPrice() + (getExtraEquipment() * 40);
            sum = (double) Math.round((sum * 100.0));
            sum = sum / 100;
        return sum;
        }else {
            return sum;
        }
    }

    public double cancel(double canceledContractPrice){
        LocalDate today = LocalDate.now();
        long noOfDays = ChronoUnit.DAYS.between(today, getStartDate());

        if(isCancel() == true && noOfDays >= 50){
            canceledContractPrice = canceledContractPrice * 0.2;
            if(canceledContractPrice < 200){
                canceledContractPrice = 200;
                return canceledContractPrice;
            }
            return canceledContractPrice;

        }else if(isCancel() == true && noOfDays <= 49 && noOfDays >= 15){
            canceledContractPrice = canceledContractPrice * 0.5;
            canceledContractPrice = Math.round((canceledContractPrice * 100.0));
            canceledContractPrice = canceledContractPrice / 100;
            return canceledContractPrice;

        }else if(isCancel() == true && noOfDays < 15 && noOfDays > 0){
            canceledContractPrice = canceledContractPrice * 0.8;
            canceledContractPrice = (double) Math.round((canceledContractPrice * 100.0));
            canceledContractPrice = canceledContractPrice / 100;
            return canceledContractPrice;

        }else if(isCancel() == true && noOfDays == 0){
            canceledContractPrice = canceledContractPrice * 0.95;
            canceledContractPrice = (double) Math.round((canceledContractPrice * 100.0));
            canceledContractPrice = canceledContractPrice / 100;
            return canceledContractPrice;
        }

        System.out.println("Something went wrong");
        return canceledContractPrice;
    }

    public double getPrice(){
        double sum = 0.0;
        sum += (getPickUpKM() + getDropOffKM()) * 0.7;
        return sum;
    }
}
