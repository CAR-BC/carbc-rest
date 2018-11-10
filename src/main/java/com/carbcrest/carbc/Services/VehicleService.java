package com.carbcrest.carbc.Services;

import java.util.ArrayList;

public interface VehicleService {
    public ArrayList<String> getMyVehicleList(String current_owner);

    public void insertIntoVehicleTable(String registrationNumber, String vehicleId, String currentOwner);

    public void updateVehicleTable(String vehicleId, String currentOwner);
}
