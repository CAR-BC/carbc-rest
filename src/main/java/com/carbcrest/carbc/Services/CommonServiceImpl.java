package com.carbcrest.carbc.Services;

import com.carbcrest.carbc.Repositories.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    IdentityRepository identityRepository;


    @Override
    public String getDataByAddress(String address) {
        return null;
    }

    @Override
    public String getAdditionalData(String block_hash) {
        return null;
    }
}
