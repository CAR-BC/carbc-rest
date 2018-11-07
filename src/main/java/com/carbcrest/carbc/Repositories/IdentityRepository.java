package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.Identity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IdentityRepository extends CrudRepository<Identity, Integer> {

    @Query(value = "SELECT * FROM Identity WHERE public_key= ?1", nativeQuery = true)
    List<Identity> findByPublicKey(String publicKey);

    @Query(value = "SELECT * FROM Identity WHERE location= ?1", nativeQuery = true)
    List<Identity> findByAddress(String address);


    @Query(value = "SELECT * FROM Identity WHERE role= ?1", nativeQuery = true)
    List<Identity> findByRole(String address);

}
