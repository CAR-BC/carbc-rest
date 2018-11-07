package com.carbcrest.carbc.Rest;

import com.carbcrest.carbc.Entities.BlockInfo;
import com.carbcrest.carbc.Entities.Identity;
import com.carbcrest.carbc.Entities.PeerDetails;
import com.carbcrest.carbc.Repositories.BlockInfoRepository;
import com.carbcrest.carbc.Services.BlockInfoService;
import com.carbcrest.carbc.Services.CommonService;
import com.carbcrest.carbc.Services.IdentityService;
import com.carbcrest.carbc.Services.PeerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    CommonService service;

    @Autowired
    BlockInfoService blockInfoService;


    @Autowired
    IdentityService identityService;

    @Autowired
    PeerDetailsService peerDetailsService;

    @RequestMapping
    public String weclome() {
        return "Hi Welocome!";
    }

    @RequestMapping(value = "/blockinfo", method = RequestMethod.GET)
    public List<BlockInfo> findByBlockNumber(@RequestParam("block_number") int block_number) {
        return blockInfoService.getBlockInfo(block_number);
    }

    @RequestMapping(value = "/vehicleinfo", method = RequestMethod.GET)
    public List<BlockInfo> findVehicleDetails(@RequestParam("transaction_id") String transaction_id,
                                              @RequestParam("event") String event, @RequestParam("address") String address) {
        return blockInfoService.getVehicleDetails(transaction_id, event, address);
    }

    @RequestMapping(value = "/findRecentblocknumber", method = RequestMethod.GET)
    public int findRecentBlockNumber() {
        return blockInfoService.getRecentBlockNumber();
    }

    @RequestMapping(value = "/findprevioushash", method = RequestMethod.GET)
    public String findPreviousHash() {
        return blockInfoService.getPreviousHash();
    }


    @RequestMapping(value = "/blockmetainfo", method = RequestMethod.GET)
    public BlockInfoRepository.BlockMetaInfo findMetaInfo() {
        return blockInfoService.getMetaInfo();
    }

    @RequestMapping(value = "/findeventdata", method = RequestMethod.GET)
    public BlockInfoRepository.BlockEventData findEventData(@RequestParam("block_hash") String block_hash) {
        return blockInfoService.getEventData(block_hash);
    }

    @RequestMapping(value = "/insertblock", method = RequestMethod.GET)
    public void insertBlock(
            @RequestParam("previous_hash") String previous_hash,
            @RequestParam("block_hash") String block_hash,
            @RequestParam("block_timestamp") String block_timestamp,
            @RequestParam("block_number") String block_number,
            @RequestParam("validity") String validity,
            @RequestParam("transaction_id") String transaction_id,
            @RequestParam("sender") String sender,
            @RequestParam("event") String event,
            @RequestParam("data") String data,
            @RequestParam("address") String address) {

        blockInfoService.insertBlockInfo(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address);

    }


    @RequestMapping(value = "/insertidentity", method = RequestMethod.POST)
    public void insertIdentity(@RequestParam("block_hash") String block_hash,
                               @RequestParam("public_key") String public_key,
                               @RequestParam("role") String role,
                               @RequestParam("name") String name,
                               @RequestParam("location") String location) {
        identityService.insertIdentity(block_hash, public_key, role, name, location);
    }

    @RequestMapping(value = "/findidentity", method = RequestMethod.GET)
    public Identity findIdentity(@RequestParam("publicKey") String publicKey) {
        return identityService.getIdentity(publicKey);
    }

    @RequestMapping(value = "/findidentitybyaddress", method = RequestMethod.GET)
    public List<Identity> findIdentityByAdsress(@RequestParam("address") String address) {
        return identityService.getIdentityByAddress(address);
    }

    @RequestMapping(value = "/findidentitybyrole", method = RequestMethod.GET)
    public Identity findIdentitybyRole(@RequestParam("role") String role) {
        return identityService.getIdentityByRole(role);
    }


    @RequestMapping(value = "/insertpeerdetails", method = RequestMethod.POST)
    public void insertPeerDetails(@RequestParam("node_id") String node_id,
                                  @RequestParam("ip") String ip,
                                  @RequestParam("port") String port,
                                  @RequestParam("public_key") String public_key) {
        peerDetailsService.insertPeerDetails(node_id, ip, port, public_key);
    }

    @RequestMapping(value = "/findpeer", method = RequestMethod.GET)
    public PeerDetails findPeer(@RequestParam("node_id") String node_id) {
        return peerDetailsService.getPeer(node_id);
    }


    @RequestMapping(value = "/findallpeers", method = RequestMethod.GET)
    public ArrayList<PeerDetails> findAllPeers() {
        return peerDetailsService.getPeers();
    }

    @RequestMapping(value = "/updatepeerdetails", method = RequestMethod.POST)
    public void updatePeerDetails(@RequestParam("node_id") String node_id,
                                  @RequestParam("ip") String ip,
                                  @RequestParam("port") String port,
                                  @RequestParam("public_key") String public_key) {
        peerDetailsService.insertPeerDetails(node_id, ip, port, public_key);
    }

}
