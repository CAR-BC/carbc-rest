package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.Identity;

import java.util.List;

public interface IdentityService {
    public boolean insertIdentity(Identity identity);
    public Identity getIdentity(String publicKey);
    public List<Identity> getIdentityByAddress(String address);
    public Identity getIdentityByRole(String role);
}
