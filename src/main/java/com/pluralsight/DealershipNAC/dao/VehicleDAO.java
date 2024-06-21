package com.pluralsight.DealershipNAC.dao;

import com.pluralsight.DealershipNAC.model.Vehicle;

import java.util.List;

public interface VehicleDAO {

    Vehicle getByName();

    Vehicle getByCategoryID();

    List<Vehicle> getAllVehicles();

    List<Vehicle> getVehicleByID(String id);

    int addVehicle(Vehicle vehicle);

    int updateVehicle(int id, Vehicle vehicle);

    boolean deleteVehicle(int id);

}
