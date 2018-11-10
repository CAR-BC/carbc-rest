package com.carbcrest.carbc.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    private String vehicle_id;
    private String registration_number;
    private String current_owner;
    


    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getregistration_number() {
        return registration_number;
    }

    public void setregistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getCurrent_owner() {
        return current_owner;
    }

    public void setCurrent_owner(String current_owner) {
        this.current_owner = current_owner;
    }
}
