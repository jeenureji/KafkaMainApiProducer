package com.microservice.kafka.mainapi.service;

import com.microservice.kafka.mainapi.client.CarPostStorClient;
import com.microservice.kafka.mainapi.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStorService {

    @Autowired
    private CarPostStorClient client;

    public List<CarPostDto> getCarForSale(){
      return   client.carForSailClient();
    }

    public void changeCarForSale(CarPostDto carPostDto, String id){
         client.carPostClient(carPostDto, id);
    }

    public void delete (String id){
        client.carDeletForClient(id);
    }
}
