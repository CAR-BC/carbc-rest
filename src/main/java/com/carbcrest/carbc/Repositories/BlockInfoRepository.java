package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.BlockInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface BlockInfoRepository extends CrudRepository<BlockInfo, Integer> {
    @Modifying
    @Query(value = "INSERT INTO Blockchain(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address, rating)  VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10, ?11)", nativeQuery = true)
    @Transactional
    void saveInBlockchain(String previous_hash,String block_hash,String block_timestamp,String block_number,String validity,String transaction_id,String sender,String event,String data,String address, String rating);


    @Query(value = "SELECT * FROM Blockchain WHERE block_number >= ?1 AND validity = 1", nativeQuery = true)
    List<BlockInfo> findByBlockNumber(int block_number);

//    @Query(value = "SELECT * FROM Blockchain WHERE transaction_id LIKE 'V%' AND validity = 1", nativeQuery = true)
    @Query(value = "SELECT * FROM Blockchain WHERE transaction_id LIKE 'V%' AND event = ?1 AND  address = ?2  AND validity = 1", nativeQuery = true)
    List<BlockInfo> findByMetaData(String event, String address);


    @Query (value = "SELECT block_hash, block_number, block_timestamp FROM Blockchain WHERE validity = 1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
    BlockMetaInfo findMetaInfo();

    public static interface BlockMetaInfo{
        String getBlock_hash();
        String getBlock_number();
        String getBlock_timestamp();
    }


    @Query (value = "SELECT event, address FROM Blockchain WHERE block_hash = ?1 AND validity = 1",nativeQuery = true)
    BlockEventData findBlockEventData(String blockHash);

    public static interface BlockEventData{
        String getEvent();
        String getAddress();
    }


    @Query (value = "SELECT block_number FROM Blockchain ORDER BY id DESC LIMIT 1",nativeQuery = true)
    RecentBlockNumber findRecentBlockNumber();

    public static interface RecentBlockNumber{
        int getBlock_number();
    }

    @Query (value = "SELECT * FROM Blockchain WHERE validity = 1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
    BlockInfo findPreviousHash();

    public static interface PreviousHash{

        String getPreviousHash();
    }

    @Query (value = "SELECT data, address, rating, current_owner FROM `Blockchain` INNER JOIN `vehicle` ON Blockchain.address = " +
            "vehicle.vehicle_id WHERE `validity` = 1 AND `event` = 'RegisterVehicle' AND " +
            "vehicle.registration_number = ?1",nativeQuery = true)
    RegisterData findRegisterData(String registration_number);

    public static interface RegisterData{
        String getData();
        String getAddress();
        String getRating();
        String getCurrent_owner();
    }

    @Query (value = "SELECT `data`, `address`, `rating`, `current_owner`, `event` FROM `Blockchain` INNER JOIN `vehicle` " +
            "ON Blockchain.address = vehicle.vehicle_id WHERE vehicle.registration_number = ?1 AND `event` NOT IN ('RegisterVehicle') " +
            "AND `validity` = 1 ORDER BY `block_number` DESC",nativeQuery = true)
    VehicleData findVehicleData(String registration_number);

    public static interface VehicleData{
        String getData();
        String getAddress();
        String getRating();
        String getCurrent_owner();
        String getEvent();
    }

    @Query (value = "SELECT `block_hash`, `block_timestamp` FROM `Blockchain` WHERE `previous_hash`= ?1",nativeQuery = true)
    ArrayList<String> checkPossibility(String pre_block_hash);

    public static interface PreBlockData{
        String getBlockHash1();
        String getTimestamp1();
    }

    @Modifying
    @Query(value = "UPDATE `Blockchain` SET `validity` = ?1 WHERE  `block_hash` = ?2", nativeQuery = true)
    @Transactional
    void setValidity(boolean validity, String blockHash);


}
