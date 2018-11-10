package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.Vehicle;
import com.carbcrest.carbc.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;


    @Override
    public ArrayList<String> getMyVehicleList(String current_owner) {
        List<Vehicle> myVehicleList = vehicleRepository.findMyVehicleList(current_owner);
        ArrayList<String> vehicleList = new ArrayList<>();
        for (int i = 0; i<myVehicleList.size() ;i++){
            vehicleList.add(myVehicleList.get(i).getVehicle_id());
        }
        return vehicleList;
    }
}
