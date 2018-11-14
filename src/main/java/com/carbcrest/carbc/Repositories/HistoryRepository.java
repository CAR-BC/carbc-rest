package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Entities.History;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface HistoryRepository  extends CrudRepository<History, Integer> {

    @Modifying
    @Query(value = "INSERT INTO History(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address, status)  VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10, ?11)", nativeQuery = true)
    @Transactional
    void saveInHistory(String previous_hash,String block_hash,String block_timestamp,String block_number,String validity,
                       String transaction_id,String sender,String event,String data,String address, String status);

    @Query(value = "SELECT event, address FROM Blockchain WHERE block_hash = ?1 AND validity = 0", nativeQuery = true)
    HistoryMetaInfo findHistoryData(String block_hash);

    public static interface HistoryMetaInfo{
        String getEvent();
        String getAddress();
    }

    @Query(value = "SELECT additional_data FROM History WHERE block_hash = ?1", nativeQuery = true)
    HistoryAdditionalData findAdditionalData(String  block_number);

    public static interface HistoryAdditionalData{
        String getAdditionalData();
    }

    @Modifying
    @Query(value = "UPDATE `History` SET `validity` = 1, `status` = 'Accepted' WHERE `block_hash` = ?1", nativeQuery = true)
    @Transactional
    void setValidity(String blockHash);


    @Query(value = "SELECT EXISTS(SELECT * FROM History WHERE `block_hash` = ?1 AND `validity` = 0)", nativeQuery = true)
    int checkExistence(String blockHash);

    @Query(value = "SELECT * FROM History", nativeQuery = true)
    List<History> getAllHistory();

    @Modifying
    @Query(value = "UPDATE `History` SET `status` = ?1 WHERE `block_hash` = ?2", nativeQuery = true)
    @Transactional
    void setStatus(String status, String blockHash);

    @Modifying
    @Query(value = "UPDATE `History` SET `status` = 'Failed' WHERE `previous_hash` = ?1 AND `status` = 'Pending'", nativeQuery = true)
    @Transactional
    void handleStatusHistory(String preBlockHash);




}
