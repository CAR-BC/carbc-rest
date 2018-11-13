package com.carbcrest.carbc.Rest;

import com.carbcrest.carbc.Entities.*;
import com.carbcrest.carbc.Repositories.BlockInfoRepository;
import com.carbcrest.carbc.Repositories.HistoryRepository;
import com.carbcrest.carbc.Services.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
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

    @Autowired
    HistoryService historyService;

    @Autowired
    VehicleService vehicleService;

    @RequestMapping
    public String weclome() {
        return "Hi Welocome!";
    }

//    @RequestMapping(value = "/blockinfo", method = RequestMethod.GET)
//    public List<BlockInfo> findByBlockNumber(@RequestParam("block_number") int block_number) {
//        return blockInfoService.getBlockInfo(block_number);
//    }


    //checked
    @RequestMapping(value = "/vehicleinfo", method = RequestMethod.GET)
    public JSONArray findVehicleDetails(@RequestParam("event") String event, @RequestParam("address") String address) {

        JSONArray response = new JSONArray();


        JSONArray res = new JSONArray();
        List<BlockInfo> a = blockInfoService.getVehicleDetails(event, address);

        if (a.size() > 0){
            response.put(true);
            for (int i = 0; i < a.size(); i++){
                res.put(a.get(i));
            }
        }else{
            response.put(false);
        }

        response.put(res);

        return response;
    }


    //checked
    @RequestMapping(value = "/findRecentblocknumber", method = RequestMethod.GET)
    public JSONArray findRecentBlockNumber() {
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put(blockInfoService.getRecentBlockNumber());
        response.put(res);
        return response;
    }

    //checked
    @RequestMapping(value = "/findprevioushash", method = RequestMethod.GET)
    public JSONArray findPreviousHash() {
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put(blockInfoService.getPreviousHash());
        response.put(res);
        return response;
    }


    //checked
    @RequestMapping(value = "/blockmetainfo", method = RequestMethod.GET)
    public JSONArray findMetaInfo() {
        BlockInfoRepository.BlockMetaInfo metaInfo = blockInfoService.getMetaInfo();
        JSONArray response = new JSONArray();

        if (metaInfo==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(metaInfo);
        response.put(res);
        return response;
    }

    //not using in android
    @RequestMapping(value = "/findeventdata", method = RequestMethod.GET)
    public BlockInfoRepository.BlockEventData findEventData(@RequestParam("block_hash") String block_hash) {
        return blockInfoService.getEventData(block_hash);
    }

//    //checked
//    @RequestMapping(value = "/searchvehicleregistrationdata", method = RequestMethod.GET)
//    public JSONArray findVehicleRegistrationData(@RequestParam("registration_number") String registration_number) {
//        BlockInfoRepository.RegisterData registrationData = blockInfoService.getRegistrationData(registration_number);
//        JSONArray array = new JSONArray();
//        array.put(registrationData);
//        System.out.println("*********************************Registration Data*********************************");
//        return array;
//    }

    //checked
    @RequestMapping(value = "/searchvehicleregistrationdata", method = RequestMethod.GET)
    public JSONArray findVehicleRegistrationData(@RequestParam("registration_number") String registration_number) {
        System.out.println("*********************************Registration Data*********************************");

        BlockInfoRepository.RegisterData registrationData = blockInfoService.getRegistrationData(registration_number);
        System.out.println(registration_number);

        JSONArray response = new JSONArray();

        if (registrationData==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(registrationData);
        response.put(res);
        return response;
    }

    //checked
    @RequestMapping(value = "/searchvehicledata", method = RequestMethod.GET)
    public JSONArray findVehicleData(@RequestParam("registration_number") String registration_number) {
        System.out.println("******************************hello*********************************************");
        BlockInfoRepository.VehicleData vehicleData = blockInfoService.getVehicleData(registration_number);
        JSONArray response = new JSONArray();

        if (vehicleData==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(vehicleData);
        response.put(res);
        return response;

    }

    //checked
    @RequestMapping(value = "/insertblock", method = RequestMethod.GET)
    public JSONArray insertBlock(
            @RequestParam("previous_hash") String previous_hash,
            @RequestParam("block_hash") String block_hash,
            @RequestParam("block_timestamp") String block_timestamp,
            @RequestParam("block_number") String block_number,
            @RequestParam("validity") String validity,
            @RequestParam("transaction_id") String transaction_id,
            @RequestParam("sender") String sender,
            @RequestParam("event") String event,
            @RequestParam("data") String data,
            @RequestParam("address") String address,
            @RequestParam("rating") String rating) {


        blockInfoService.insertBlockInfo(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address, rating);
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);

        return response;
    }


    @RequestMapping(value = "/insertidentity", method = RequestMethod.GET)
    public JSONArray insertIdentity(@RequestParam("block_hash") String block_hash,
                               @RequestParam("public_key") String public_key,
                               @RequestParam("role") String role,
                               @RequestParam("name") String name,
                               @RequestParam("location") String location) {
        identityService.insertIdentity(block_hash, public_key, role, name, location);
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;
    }

    //checked
    @RequestMapping(value = "/findidentity", method = RequestMethod.GET)
    public JSONArray findIdentity(@RequestParam("publicKey") String publicKey) {
        Identity identity= identityService.getIdentity(publicKey);
        JSONArray response = new JSONArray();

        if (identity==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(identity);
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/findidentitybyaddress", method = RequestMethod.GET)
    public JSONArray findIdentityByAddress(@RequestParam("address") String address) {
        System.out.println("+++++++++++++++++++++++++++findidentitybyaddress");
        List<Identity> identityArray = identityService.getIdentityByAddress(address);
        JSONArray response = new JSONArray();
        JSONArray res = new JSONArray();

        if (identityArray.size()>0){
            response.put(true);
        }else{
            response.put(false);
        }

        for (int i = 0; i < identityArray.size(); i++){
            res.put(identityArray.get(i));
        }
        response.put(res);

        return response;
    }

//    @RequestMapping(value = "/findidentitybyaddress", method = RequestMethod.GET)
//    public List<Identity> findIdentityByAdsress(@RequestParam("address") String address) {
//        return identityService.getIdentityByAddress(address);
//    }

//    @RequestMapping(value = "/findidentitybyrole", method = RequestMethod.GET)
//    public JSONArray findIdentitybyRole(@RequestParam("role") String role) {
//        JSONArray res = new JSONArray();
//        res.put(identityService.getIdentityByRole(role));
//
//        return res;
//    }

    @RequestMapping(value = "/findidentitybyrole", method = RequestMethod.GET)
    public JSONArray findIdentitybyRole1(@RequestParam("role") String role) {
        Identity identity = identityService.getIdentityByRole(role);
        JSONArray response = new JSONArray();

        if (identity==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(identity);
        response.put(res);
        return response;
    }


    @RequestMapping(value = "/insertpeerdetails", method = RequestMethod.GET)
    public JSONArray insertPeerDetails(@RequestParam("node_id") String node_id,
                                  @RequestParam("ip") String ip,
                                  @RequestParam("port") String port,
                                  @RequestParam("public_key") String public_key) {
        peerDetailsService.insertPeerDetails(node_id, ip, port, public_key);
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;
    }


    @RequestMapping(value = "/findpeer", method = RequestMethod.GET)
    public JSONArray findPeer(@RequestParam("node_id") String node_id) {
        PeerDetails peerDetails = peerDetailsService.getPeer(node_id);
        JSONArray response = new JSONArray();

        if (peerDetails==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(peerDetails);
        response.put(res);
        return response;
    }


    //checked
    @RequestMapping(value = "/findallpeers", method = RequestMethod.GET)
    public JSONArray findAllPeers() {
        ArrayList<PeerDetails> peerDetails = peerDetailsService.getPeers();

        JSONArray response = new JSONArray();
        JSONArray res = new JSONArray();

        if (peerDetails.size()>0){
            response.put(true);
            for (int i = 0; i < peerDetails.size(); i++){
                res.put(peerDetails.get(i));
            }
        }else{
            response.put(false);
        }
        response.put(res);

        return response;

    }

    @RequestMapping(value = "/updatepeerdetails", method = RequestMethod.GET)
    public void updatePeerDetails(@RequestParam("node_id") String node_id,
                                  @RequestParam("ip") String ip,
                                  @RequestParam("port") String port,
                                  @RequestParam("public_key") String public_key) {
        peerDetailsService.insertPeerDetails(node_id, ip, port, public_key);
    }


    @RequestMapping(value = "/inserthistory", method = RequestMethod.GET)
    public JSONArray insertHistory(
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

        historyService.insertHistory(previous_hash, block_hash, block_timestamp, block_number, validity, transaction_id, sender, event, data, address);

        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;

    }


    @RequestMapping(value = "/findhistoryadditionaldata", method = RequestMethod.GET)
    public JSONArray findAdditionalData(@RequestParam("block_hash") String block_hash) {
        HistoryRepository.HistoryAdditionalData historyAdditionalData = historyService.findAdditionalData(block_hash);

        JSONArray response = new JSONArray();

        if (historyAdditionalData==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(historyAdditionalData);
        response.put(res);
        return response;
    }

    //checked
    @RequestMapping(value = "/findhistorymetainfo", method = RequestMethod.GET)
    public JSONArray findHistoryMetaInfo(@RequestParam("block_hash") String block_hash) {
        HistoryRepository.HistoryMetaInfo historyMetaInfo = historyService.findMetaInfo(block_hash);
        JSONArray response = new JSONArray();

        if (historyMetaInfo==null){
            response.put(false);
        }else{
            response.put(true);
        }

        JSONArray res = new JSONArray();
        res.put(historyMetaInfo);
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/findallhistory", method = RequestMethod.GET)
    public JSONArray findAllHistory() {

        List<History> allHistory = historyService.getAllHistory();

//        System.out.println(allHistory);

        JSONArray response = new JSONArray();
        JSONArray res = new JSONArray();

        if (allHistory.size()>0){
            response.put(true);
            for (int i = 0; i < allHistory.size(); i++){
                res.put(allHistory.get(i));
                System.out.println(allHistory.get(i).getAddress());
                System.out.println(allHistory.get(i).isValidity());
            }
        }else{
            response.put(false);
        }
        response.put(res);

        return response;

    }


    //checked
    @RequestMapping(value = "/findmyvehiclenumbers", method = RequestMethod.GET)
    public JSONArray findMyVehicleNumbers(@RequestParam("current_owner") String current_owner) {
        List<Vehicle> myVehicleList = vehicleService.getMyVehicleList(current_owner);

        JSONArray response = new JSONArray();
        JSONArray res = new JSONArray();
//        for(String s: myVehicleList) {
//            System.out.println(s);
//        }

        if (myVehicleList.size()>0){
            response.put(true);
            for (int i = 0; i < myVehicleList.size(); i++){
                res.put(myVehicleList.get(i));
            }
        }else{
            response.put(false);
        }
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/insertintovehicle", method = RequestMethod.GET)
    public JSONArray insertIntoVehicle(@RequestParam("registration_number") String registration_number,
                                  @RequestParam("vehicle_id") String vehicle_id,
                                  @RequestParam("current_owner") String current_owner ){
        System.out.println("recieved");
        vehicleService.insertIntoVehicleTable(registration_number, vehicle_id, current_owner);

        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/updatevehicle", method = RequestMethod.GET)
    public JSONArray updateVehicle(@RequestParam("vehicle_id") String vehicle_id,
                                  @RequestParam("current_owner") String current_owner ){
        vehicleService.updateVehicleTable(vehicle_id, current_owner);

        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/setvalidity", method = RequestMethod.GET)
    public JSONArray setValidity(@RequestParam("block_hash") String block_hash){
        historyService.setValidity(block_hash);

        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/checkexistence", method = RequestMethod.GET)
    public JSONArray checkExistence(@RequestParam("block_hash") String block_hash){
        int existenceInfo = historyService.checkExistence(block_hash);

        System.out.println(existenceInfo);
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put(existenceInfo);
        response.put(res);
        return response;
    }

    @RequestMapping(value = "/checkpossibility", method = RequestMethod.GET)
    public JSONArray checkPossibility(@RequestParam("pre_block_hash") String pre_block_hash){
        System.out.println(pre_block_hash);
        ArrayList<String> preBlockData = blockInfoService.checkPossibility(pre_block_hash);


        System.out.println(preBlockData.size());
        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        for (int i = 0; i < preBlockData.size(); i++){
            res.put(preBlockData.get(i));
        }

        response.put(res);
        return response;
    }

    @RequestMapping(value = "/setvalidityinblockchain", method = RequestMethod.GET)
    public JSONArray setValidity(@RequestParam("validity") boolean validity,
                                 @RequestParam("block_hash") String block_hash){
        blockInfoService.setValidity(validity, block_hash);

        JSONArray response = new JSONArray();
        response.put(true);

        JSONArray res = new JSONArray();
        res.put("succeed");
        response.put(res);
        return response;
    }
}
