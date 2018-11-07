package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Repositories.BlockInfoRepository;

import java.util.List;

public interface BlockInfoService {
    //public boolean insertBlockInfo(BlockInfo blockInfo);
    public List<BlockInfo> getBlockInfo(int block_number);
    public List<BlockInfo> getVehicleDetails(String transaction_id, String event, String address);

    public int getRecentBlockNumber();
    public String getPreviousHash();

    public BlockInfoRepository.BlockMetaInfo getMetaInfo();
    public BlockInfoRepository.BlockEventData getEventData(String blockHash);


    public boolean insertHistory(BlockInfo blockInfo);
    public String getAdditionalData(String block_hash);

    public void insertBlockInfo(String previous_hash, String block_hash, String block_timestamp, String block_number, String validity, String transaction_id, String sender, String event, String data, String address);

    }
