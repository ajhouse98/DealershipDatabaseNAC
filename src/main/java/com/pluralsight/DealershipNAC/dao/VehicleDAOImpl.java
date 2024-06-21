package com.pluralsight.DealershipNAC.dao;

import com.pluralsight.DealershipNAC.model.Vehicle;
import com.pluralsight.DealershipNAC.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDAOImpl implements VehicleDAO {

    private DataSource dataSource;

    @Autowired
    public VehicleDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Vehicle getByName() {
        return null;
    }

    @Override
    public Vehicle getByCategoryID() {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM Vehicles;";
        try(Connection connection = dataSource.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(sql);
            while(rows.next()){
                vehicles.add(VehicleService.generateVehicle(rows));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return vehicles;
    }

    @Override
    public List<Vehicle> getVehicleByID(String id) {
        List<Vehicle> vehicle = new ArrayList<>();

        String sql = "SELECT * FROM Vehicles WHERE VIN = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                vehicle.add(VehicleService.generateVehicle(rows));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return vehicle;
    }

    @Override
    public int addVehicle(Vehicle vehicle) {
        int res = 0;

        String sql = "INSERT INTO Vehicles(VehicleName, CategoryID, QuantityPerUnit, UnitsInStock, UnitsOnOrder, UnitPrice) VALUES(?,?,?,?,?,?);";

        try(Connection connection = dataSource.getConnection();){
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, vehicle.getVIN());
            statement.setString(2, vehicle.getMake());
            statement.setString(3, vehicle.getModel());
            statement.setInt(4, vehicle.getCarYear());
            statement.setBoolean(5, vehicle.isSOLD());
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                // Iterate through the primary keys that were generated
                while (keys.next()) {
                    res = keys.getInt(1);
                }
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return res;
    }

    @Override
    public int updateVehicle(int id, Vehicle vehicle) {
        int res = 0;

        String sql = "UPDATE Vehicles SET VehicleName = ?, CategoryID = ?, QuantityPerUnit = ?, UnitsInStock = ?, UnitsOnOrder = ?, UnitPrice = ? WHERE VehicleID = ?";

        try(Connection connection = dataSource.getConnection();){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vehicle.getVIN());
            statement.setString(2, vehicle.getMake());
            statement.setString(3, vehicle.getModel());
            statement.setInt(4, vehicle.getCarYear());
            statement.setBoolean(5, vehicle.isSOLD());
            res = statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return res;
    }

    @Override
    public boolean deleteVehicle(int id) {
        String sql = "DELETE FROM Vehicles WHERE VehicleID = ?";

        try(Connection connection = dataSource.getConnection();){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

}
