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
    public String weclome(){
        return "Hi Welocome!";
    }

    @RequestMapping(value = "/blockinfo", method = RequestMethod.GET)
    public List<BlockInfo> findByBlockNumber(@RequestParam("block_number") int block_number){
        return blockInfoService.getBlockInfo(block_number);
    }

    @RequestMapping(value = "/vehicleinfo", method = RequestMethod.GET)
    public List<BlockInfo>  findVehicleDetails(@RequestParam("transaction_id") String transaction_id,
                                               @RequestParam("event") String  event, @RequestParam("address") String address){
        return blockInfoService.getVehicleDetails(transaction_id,event,address);
    }

    @RequestMapping(value = "/findRecentblocknumber", method = RequestMethod.GET)
    public int  findRecentBlockNumber(){
        return blockInfoService.getRecentBlockNumber();
    }

    @RequestMapping(value = "/findprevioushash", method = RequestMethod.GET)
    public String  findPreviousHash(){
        return blockInfoService.getPreviousHash();
    }


    @RequestMapping(value = "/blockmetainfo", method = RequestMethod.GET)
    public BlockInfoRepository.BlockMetaInfo  findMetaInfo(){
        return blockInfoService.getMetaInfo();
    }

    @RequestMapping(value = "/findeventdata", method = RequestMethod.GET)
    public BlockInfoRepository.BlockEventData findEventData(@RequestParam("block_hash") String  block_hash){
        return blockInfoService.getEventData(block_hash);
    }

    @RequestMapping(value = "/insertblock", method = RequestMethod.POST)
    public boolean insertBlock(@RequestBody BlockInfo blockInfo){
        return blockInfoService.insertBlockInfo(blockInfo);
    }


    @RequestMapping(value = "/insertidentity", method = RequestMethod.POST)
    public boolean insertIdentity(@RequestBody Identity identity){
        return identityService.insertIdentity(identity);
    }

    @RequestMapping(value = "/findidentity", method = RequestMethod.GET)
    public Identity findIdentity(@RequestParam("publicKey") String  publicKey){
        return identityService.getIdentity(publicKey);
    }

    @RequestMapping(value = "/findidentitybyaddress", method = RequestMethod.GET)
    public List<Identity> findIdentityByAdsress(@RequestParam("address") String  address){
        return identityService.getIdentityByAddress(address);
    }

    @RequestMapping(value = "/findidentitybyrole", method = RequestMethod.GET)
    public Identity findIdentitybyRole(@RequestParam("role") String  role){
        return identityService.getIdentityByRole(role);
    }




    @RequestMapping(value = "/insertpeerdetails", method = RequestMethod.POST)
    public boolean insertPeerDetails(@RequestBody PeerDetails peerDetails){
        return peerDetailsService.insertPeerDetails(peerDetails);
    }

    @RequestMapping(value = "/findpeer", method = RequestMethod.GET)
    public PeerDetails findPeer(@RequestParam("node_id") String  node_id){
        return peerDetailsService.getPeer(node_id);
    }


    @RequestMapping(value = "/findallpeers", method = RequestMethod.GET)
    public ArrayList<PeerDetails> findAllPeers(){
        return peerDetailsService.getPeers();
    }

    @RequestMapping(value = "/updatepeerdetails", method = RequestMethod.POST)
    public boolean updatePeerDetails(@RequestBody PeerDetails peerDetails) {
        return peerDetailsService.insertPeerDetails(peerDetails);
    }

}
