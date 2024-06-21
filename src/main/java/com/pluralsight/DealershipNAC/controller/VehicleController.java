package com.pluralsight.DealershipNAC.controller;

import com.pluralsight.DealershipNAC.model.Vehicle;
import com.pluralsight.DealershipNAC.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @RequestMapping(path="/", method= RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @RequestMapping(path="/vehicles", method=RequestMethod.GET)
    public List<Vehicle> vehicles() {
        return vehicleService.getAllVehicles();
    }

    @RequestMapping(path="/vehicles/{id}", method=RequestMethod.GET)
    public List<Vehicle> vehicle(@PathVariable String id) {
        return vehicleService.getVehicleByID(id);
    }

    @RequestMapping(path="/vehicles", method=RequestMethod.POST)
    public int addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @RequestMapping(path="/vehicles/{id}", method=RequestMethod.PUT)
    public int updatevehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @RequestMapping(path="/vehicles/{id}", method=RequestMethod.DELETE)
    public boolean deleteVehicle(@PathVariable int id) {
        return vehicleService.deleteVehicle(id);
    }

}
