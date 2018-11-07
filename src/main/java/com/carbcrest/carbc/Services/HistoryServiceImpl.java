package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryRepository historyRepository;
    @Override
    public void insertHistory(String previous_hash, String block_hash, String block_timestamp, String block_number, String validity, String transaction_id, String sender, String event, String data, String address) {
        historyRepository.saveInHistory(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address);

    }

    @Override
    public HistoryRepository.HistoryMetaInfo findMetaInfo(String block_hash) {
        return historyRepository.findHistoryData(block_hash);
    }

    @Override
    public HistoryRepository.HistoryAdditionalData findAdditionalData(String block_hash) {
        return historyRepository.findAdditionalData(block_hash);
    }
}