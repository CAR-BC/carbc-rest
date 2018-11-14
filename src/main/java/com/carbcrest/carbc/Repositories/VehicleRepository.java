package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {


    @Query(value = "SELECT `registration_number`, `vehicle_id`, `current_owner` FROM `vehicle` WHERE `current_owner` = ?", nativeQuery = true)
    List<Vehicle> findMyVehicleList(String current_owner);

    @Modifying
    @Query(value = "INSERT INTO `vehicle` (registration_number, vehicle_id, current_owner)  VALUES (?1,?2,?3)", nativeQuery = true)
    @Transactional
    void insertIntoVehicleTable(String registrationNumber, String vehicleId, String currentOwner);

    @Modifying
    @Query(value = "UPDATE vehicle SET `current_owner` = ?1 WHERE `vehicle_id` = ?2", nativeQuery = true)
    @Transactional
    void updateVehicleTable(String currentOwner, String vehicleId);

    @Query(value = "SELECT COUNT(*) FROM `vehicle` WHERE registration_number = ?1", nativeQuery = true)
    int searchVehicleByRegNo(String registration_number);

    @Query(value = "SELECT `current_owner` FROM `vehicle` WHERE registration_number = ?1", nativeQuery = true)
    String getVehicleOwnerByRegNo(String registration_number);




}
