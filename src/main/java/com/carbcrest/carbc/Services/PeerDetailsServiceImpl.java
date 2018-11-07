package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.PeerDetails;
import com.carbcrest.carbc.Repositories.PeerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeerDetailsServiceImpl implements PeerDetailsService {

    @Autowired
    PeerDetailsRepository peerDetailsRepository;


//    @Override
//    public PeerDetails getPeerDetails(String publicKey) {
//        return null;
//    }
//
//    @Override
//    public PeerDetails getPeerPublicKey(String peerID) {
//        return null;
//    }
//
//    @Override
//    public PeerDetails getPeersByLocation(String location) {
//        return null;
//    }

    @Override
    public void insertPeerDetails(String node_id, String ip, String port, String public_key) {
        peerDetailsRepository.saveInPeerDetails(node_id,ip,port,public_key);
    }

    @Override
    public PeerDetails getPeer(String node_id) {
        PeerDetails peerDetails = peerDetailsRepository.findByNodeId(node_id);
        return peerDetails;
    }

    @Override
    public ArrayList<PeerDetails> getPeers() {
        ArrayList<PeerDetails> peerDetailsList = (ArrayList<PeerDetails>) peerDetailsRepository.getAllPeer();
        return peerDetailsList;
    }

    @Override
    public boolean updatePeer(PeerDetails peerDetails) {
//        List<PeerDetails> peerDetails = peerDetailsRepository.updatePeer(ip, port, nodeID);
//        if (peerDetails == null){
//            return false;
//        }
//        return true;

        PeerDetails saved = peerDetailsRepository.save(peerDetails);
        if (saved == null){
            return false;
        }
        return true;
    }
}
