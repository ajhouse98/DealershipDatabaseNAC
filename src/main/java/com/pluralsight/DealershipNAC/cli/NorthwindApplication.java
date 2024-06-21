package com.pluralsight.DealershipNAC.cli;

import com.pluralsight.DealershipNAC.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NorthwindApplication implements CommandLineRunner {

    private final VehicleService vehicleService;

    @Autowired
    public NorthwindApplication(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @Override
    public void run(String... args) throws Exception {
//        System.out.println(vehicleService.getAllvehicles());
    }
}
