package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public interface VehicleService {
    public List<Vehicle> getMyVehicleList(String current_owner);

    public void insertIntoVehicleTable(String registrationNumber, String vehicleId, String currentOwner);

    public void updateVehicleTable(String vehicleId, String currentOwner);

    public int searchVehicleByRegistrationNumber(String regNo);

    public String getVehicleOwnerByRegistrationNumber(String regNo);
}
