package com.pluralsight.DealershipNAC.model;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private int CarYear;
    private String VIN,Make,Model;
    boolean SOLD;

    public Vehicle() {
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VehicleID) {
        this.VIN = VehicleID;
    }


    public String getMake() {
        return Make;
    }

    public void setMake (String Make) {
        this.Make = Make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel (String Model) {
            this.Model = Model;
    }

    public int getCarYear() {return CarYear;}

    public void setCarYear(int carYear) {CarYear = carYear;}

    public boolean isSOLD() {return SOLD;}

    public void setSOLD(boolean SOLD) {this.SOLD = SOLD;}
}
