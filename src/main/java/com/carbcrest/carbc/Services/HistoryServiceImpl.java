package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Entities.History;
import com.carbcrest.carbc.Repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryRepository historyRepository;
    @Override
    public void insertHistory(String previous_hash, String block_hash, String block_timestamp, String block_number, String validity, String transaction_id, String sender, String event, String data, String address, String status) {
        System.out.println("came********************************");
        historyRepository.saveInHistory(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address, status);

    }

    @Override
    public HistoryRepository.HistoryMetaInfo findMetaInfo(String block_hash) {
        return historyRepository.findHistoryData(block_hash);
    }

    @Override
    public HistoryRepository.HistoryAdditionalData findAdditionalData(String block_hash) {
        return historyRepository.findAdditionalData(block_hash);
    }

    @Override
    public void setValidity(String blockHash) {
        historyRepository.setValidity(blockHash);
    }

    @Override
    public int checkExistence(String blockHash) {
        return historyRepository.checkExistence(blockHash);
    }

    @Override
    public List<History> getAllHistory() {
        List<History> peerDetailsList =  historyRepository.getAllHistory();
        return peerDetailsList;
    }

    @Override
    public void setStatus(String status, String blockHash){
        historyRepository.setStatus(status, blockHash);
    }

    @Override
    public void handleStatusHistory(String preBlockHash) {
        historyRepository.handleStatusHistory(preBlockHash);
    }
}
