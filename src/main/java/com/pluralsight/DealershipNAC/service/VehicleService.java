package com.pluralsight.DealershipNAC.service;

import com.pluralsight.DealershipNAC.dao.VehicleDAO;
import com.pluralsight.DealershipNAC.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.sql.*;

@Component
public class VehicleService {

    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleService(VehicleDAO vehicleDAOImpl) {
        this.vehicleDAO = vehicleDAOImpl;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }

    public List<Vehicle> getVehicleByID(String id) {
        return vehicleDAO.getVehicleByID(id);
    }

    public int addVehicle(Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle);
    }

    public int updateVehicle(int id, Vehicle vehicle) {
        return vehicleDAO.updateVehicle(id, vehicle);
    }

    public boolean deleteVehicle(int id) {
        return vehicleDAO.deleteVehicle(id);
    }


    public static Vehicle generateVehicle(ResultSet rs) throws SQLException {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVIN(rs.getString("VIN"));
        newVehicle.setMake(rs.getString("Make"));
        newVehicle.setModel(rs.getString("Model"));
        newVehicle.setCarYear(rs.getInt("CarYear"));
        newVehicle.isSOLD();
        return newVehicle;
    }

}
