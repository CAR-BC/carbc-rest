package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.BlockInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlockInfoRepository extends CrudRepository<BlockInfo, Integer> {

    @Query(value = "SELECT * FROM Blockchain WHERE block_number >= ?1 AND validity = 1", nativeQuery = true)
    List<BlockInfo> findByBlockNumber(int block_number);

    @Query(value = "SELECT * FROM Blockchain WHERE transaction_id LIKE ?1 AND event = ?2 AND  address >= ?3  AND validity = 1", nativeQuery = true)
    List<BlockInfo> findByMetaData(String transaction_id, String event,String address);


    @Query (value = "SELECT block_hash,block_number, block_timestamp FROM Blockchain WHERE validity = 1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
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

    @Query (value = "SELECT block_hash FROM Blockchain WHERE validity = 1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
    PreviousHash findPreviousHash();

    public static interface PreviousHash{
        String getPreviousHash();
    }

}
