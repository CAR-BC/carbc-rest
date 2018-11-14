package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Entities.Identity;
import com.carbcrest.carbc.Repositories.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    private
    IdentityRepository identityRepository;


    @Override
    public void insertIdentity(String block_hash, String public_key, String role, String name, String location) {
        identityRepository.saveInIdentity(block_hash,public_key,role,name,location);
    }

    @Override
    public Identity getIdentity(String publicKey) {
        List<Identity> identities = identityRepository.findByPublicKey(publicKey);
        if (identities.size()<1){
            return null;
        }
        return identities.get(0);
    }

    @Override
    public List<Identity> getIdentityByAddress(String address) {
        List<Identity> identities = identityRepository.findByAddress(address);
        if (identities.size()<1){
            return null;
        }
        return identities;
    }

    @Override
    public Identity getIdentityByRole(String role) {
        List<Identity> identities = identityRepository.findByRole(role);
        if (identities.size()<1){
            return null;
        }
        return identities.get(0);
    }

    @Override
    public List<Identity> getServiceStation() {
        List<Identity> identities = identityRepository.getServiceStations();
        if (identities.size()<1){
            return null;
        }
        return identities;
    }
}
