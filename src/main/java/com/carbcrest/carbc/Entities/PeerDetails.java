package com.carbcrest.carbc.Entities;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PeerDetails")

public class PeerDetails {
    @Id
    private String node_id;
    private String ip;
    private int port;
    private String public_key;


    public String getnode_id() {
        return node_id;
    }

    public void setnode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getpublic_key() {
        return public_key;
    }

    public void setpublic_key(String public_key) {
        this.public_key = public_key;
    }
}
