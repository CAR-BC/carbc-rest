package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Repositories.BlockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockInfoServiceImpl implements BlockInfoService{

    @Autowired
    BlockInfoRepository blockInfoRepository;

    @Override
    public boolean insertBlockInfo(BlockInfo blockInfo) {
        BlockInfo saved = blockInfoRepository.save(blockInfo);
        if (saved == null){
            return false;
        }
        return true;
    }

    @Override
    public List<BlockInfo> getBlockInfo(int block_number) {
        List<BlockInfo> blockInfos = blockInfoRepository.findByBlockNumber(block_number);
        return blockInfos;
    }

    @Override
    public List<BlockInfo> getVehicleDetails(String transaction_id, String event, String address) {
        List<BlockInfo> blockInfos = blockInfoRepository.findByMetaData(transaction_id, event, address);
        return blockInfos;
    }


    @Override
    public int getRecentBlockNumber() {
        int block_number = blockInfoRepository.findRecentBlockNumber().getBlock_number();
        return block_number;
    }

    @Override
    public String getPreviousHash() {
        String previousHash = blockInfoRepository.findPreviousHash().getPreviousHash();
        return previousHash;
    }

    @Override
    public BlockInfoRepository.BlockMetaInfo getMetaInfo() {
        BlockInfoRepository.BlockMetaInfo metaInfo = blockInfoRepository.findMetaInfo();
        return metaInfo;
    }

    @Override
    public BlockInfoRepository.BlockEventData getEventData(String blockhash) {
        BlockInfoRepository.BlockEventData eventData = blockInfoRepository.findBlockEventData(blockhash);
        return eventData;
    }

    @Override
    public boolean insertHistory(BlockInfo blockInfo) {
        return false;
    }

    @Override
    public String getAdditionalData(String block_hash) {
        return null;
    }
}
