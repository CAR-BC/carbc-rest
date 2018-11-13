package com.carbcrest.carbc.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class History {

    //details from blockheader
    @Id
    private int id;
    private String previous_hash;
    private String block_hash;
    private Timestamp block_timestamp;
    private long block_number;
    private boolean validity;

    //details from bloc kbody
    private String transaction_id;
    private String sender;
    private String event;
    private String data;
    private String address;
    private String additional_data;

//    public BlockInfo(String previous_hash, String block_hash, Timestamp block_timestamp, long block_number, boolean validity, String transaction_id, String sender, String event, String data, String address) {
//        this.previous_hash = previous_hash;
//        this.block_hash = block_hash;
//        this.block_timestamp = block_timestamp;
//        this.block_number = block_number;
//        this.validity = validity;
//        this.transaction_id = transaction_id;
//        this.sender = sender;
//        this.event = event;
//        this.data = data;
//        this.address = address;
//    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public String getBlock_hash() {
        return block_hash;
    }

    public void setBlock_hash(String block_hash) {
        this.block_hash = block_hash;
    }

    public Timestamp getBlock_timestamp() {
        return block_timestamp;
    }

    public void setBlock_timestamp(Timestamp block_timestamp) {
        this.block_timestamp = block_timestamp;
    }

    public long getBlock_number() {
        return block_number;
    }

    public void setBlock_number(long block_number) {
        this.block_number = block_number;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdditional_data() {
        return additional_data;
    }

    public void setAdditional_data(String additional_data) {
        this.additional_data = additional_data;
    }
}

