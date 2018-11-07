package com.carbcrest.carbc.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Identity")
public class Identity {

    @Id
    private String block_hash;
    private String public_key;
    private String role;
    private String name;
    private String location;

//    public Identity(String block_hash, String public_key, String role, String name, String location){
//        this.block_hash = block_hash;
//        this.role = role;
//        this.name = name;
//        this.public_key = public_key;
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

    public String getPublic_key() {
        return public_key;
    }

    public String getLocation() {
        return location;
    }
}