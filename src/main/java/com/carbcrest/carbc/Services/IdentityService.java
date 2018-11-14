package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.Identity;

import java.util.List;

public interface IdentityService {
    public void insertIdentity(String block_hash,String public_key,String role,String name,String location);
    public Identity getIdentity(String publicKey);
    public List<Identity> getIdentityByAddress(String location);
    public Identity getIdentityByRole(String role);
    public List<Identity> getServiceStation();

}
