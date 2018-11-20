package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Entities.History;
import com.carbcrest.carbc.Repositories.HistoryRepository;

import java.util.ArrayList;
import java.util.List;

public interface HistoryService {
    public void insertHistory(String previous_hash, String block_hash, String block_timestamp,
                              String block_number, String validity, String transaction_id,
                              String sender, String event, String data, String address, String status);

    public HistoryRepository.HistoryMetaInfo findMetaInfo(String block_hash);

    public HistoryRepository.HistoryAdditionalData findAdditionalData(String block_hash);

    public void setValidity(String blockHash);

    public int checkExistence(String blockHash);

    public List<History> getAllHistory();

    public void setStatus(String status, String blockHash);

    public void handleStatusHistory(String preBlockHash);

    public HistoryRepository.ResendHistory getHistoryDataToResendBlock(String block_hash);

    public void deleteRecord(String blockHash);
}
