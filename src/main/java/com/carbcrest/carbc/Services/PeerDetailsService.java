package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.PeerDetails;

import java.util.ArrayList;

public interface PeerDetailsService {

    public boolean insertPeerDetails(PeerDetails peerDetails);
//    public PeerDetails getPeerDetails(String publicKey);
//    public PeerDetails getPeerPublicKey(String peerID);
//    public PeerDetails getPeersByLocation(String location);
    public PeerDetails getPeer(String nodeID);
    public ArrayList<PeerDetails> getPeers();
    public boolean updatePeer(PeerDetails peerDetails);
}
