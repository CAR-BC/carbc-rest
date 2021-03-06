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
    public List<Vehicle> getMyVehicleList(String current_owner) {
        List<Vehicle> myVehicleList = vehicleRepository.findMyVehicleList(current_owner);
//        ArrayList<String> vehicleList = new ArrayList<>();
//        for (int i = 0; i<myVehicleList.size() ;i++){
//            vehicleList.add(myVehicleList.get(i).getVehicle_id());
//        }
        return myVehicleList;
    }

    @Override
    public void insertIntoVehicleTable(String registrationNumber, String vehicleId, String currentOwner) {
        vehicleRepository.insertIntoVehicleTable(registrationNumber, vehicleId, currentOwner);
    }

    @Override
    public void updateVehicleTable(String vehicleId, String currentOwner) {
        vehicleRepository.updateVehicleTable(currentOwner, vehicleId);
    }

    @Override
    public int searchVehicleByRegistrationNumber(String regNo) {
        return vehicleRepository.searchVehicleByRegNo(regNo);
    }

    @Override
    public String getVehicleOwnerByRegistrationNumber(String regNo) {
        return vehicleRepository.getVehicleOwnerByRegNo(regNo);
    }

}
