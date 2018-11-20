package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.Identity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IdentityRepository extends CrudRepository<Identity, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Identity(block_hash, public_key, role, name, location)  VALUES (?1,?2,?3,?4,?5)", nativeQuery = true)
    @Transactional
    void saveInIdentity(String block_hash,String public_key,String role,String name,String location);


    @Query(value = "SELECT * FROM Identity WHERE public_key= ?1", nativeQuery = true)
    List<Identity> findByPublicKey(String publicKey);

    @Query(value = "SELECT * FROM Identity WHERE location= ?1", nativeQuery = true)
    List<Identity> findByAddress(String address);


    @Query(value = "SELECT * FROM Identity WHERE role= ?1", nativeQuery = true)
    List<Identity> findByRole(String address);

    @Query(value = "SELECT `block_hash`, `public_key`, `role`, `name`, `location`, `longitude`, `latitude` FROM `Identity` WHERE `role` = 'ServiceStation'", nativeQuery = true)
    List<Identity> getServiceStations();


}
