package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {


    @Query(value = "SELECT `registration_number`, `vehicle_id`, `current_owner` FROM `vehicle` WHERE `current_owner` = ?", nativeQuery = true)
    List<Vehicle> findMyVehicleList(String current_owner);

}
