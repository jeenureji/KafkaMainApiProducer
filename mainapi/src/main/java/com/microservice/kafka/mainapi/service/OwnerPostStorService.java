package com.microservice.kafka.mainapi.service;

import com.microservice.kafka.mainapi.client.CarPostStorClient;
import com.microservice.kafka.mainapi.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostStorService {
    @Autowired
    private CarPostStorClient client;

    public void postOwner(OwnerPostDto ownerPostDto){
         client.ownerPostClient(ownerPostDto);
    }
}
