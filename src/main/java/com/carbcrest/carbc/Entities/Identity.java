package com.carbcrest.carbc.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Identity")
public class Identity {

    @Id
    private String block_hash;
    private String publicKey;
    private String role;
    private String name;
    private String location;

//    public Identity(String block_hash, String publicKey, String role, String name, String location){
//        this.block_hash = block_hash;
//        this.role = role;
//        this.name = name;
//        this.publicKey = publicKey;
//        this.location = location;
//    }

    public String getBlock_hash() {
        return block_hash;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getpublicKey() {
        return publicKey;
    }

    public String getLocation() {
        return location;
    }
}