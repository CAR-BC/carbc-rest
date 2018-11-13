package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Repositories.BlockInfoRepository;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public interface BlockInfoService {
    //public boolean insertBlockInfo(BlockInfo blockInfo);
    public List<BlockInfo> getBlockInfo(int block_number);

    public List<BlockInfo> getVehicleDetails(String event, String address);

    public int getRecentBlockNumber();

    //    public BlockInfoRepository.PreviousHash getPreviousHash();
    public String getPreviousHash();

    public BlockInfoRepository.BlockMetaInfo getMetaInfo();

    public BlockInfoRepository.BlockEventData getEventData(String blockHash);


    public boolean insertHistory(BlockInfo blockInfo);

    public String getAdditionalData(String block_hash);

    public void insertBlockInfo(String previous_hash, String block_hash, String block_timestamp, String block_number,
                                String validity, String transaction_id, String sender, String event, String data, String address, String rating);

    public BlockInfoRepository.RegisterData getRegistrationData(String registration_number);

    public BlockInfoRepository.VehicleData getVehicleData(String registration_number);

    public ArrayList<String> checkPossibility(String pre_block_hash);

    public void setValidity(boolean validity, String blockHash);

}
