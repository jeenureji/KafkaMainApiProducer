package com.microservice.kafka.mainapi.client;

import com.microservice.kafka.mainapi.dto.CarPostDto;
import com.microservice.kafka.mainapi.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStorClient {

    private final String USER_STOR_SERVICE_URL = "http://localhost:8080/user";
    private final String POST_STOR_SERVICE_URL = "http://localhost:8080/sales";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDto> carForSailClient(){
        ResponseEntity<CarPostDto[]> responseEntity =
                restTemplate.getForEntity(POST_STOR_SERVICE_URL+"/car", CarPostDto[].class);
        return Arrays.asList(Objects.requireNonNull( responseEntity.getBody()));
    }

    public void ownerPostClient(OwnerPostDto ownerPostDto){
        restTemplate.postForEntity(USER_STOR_SERVICE_URL, ownerPostDto, OwnerPostDto.class);
    }

    public void carPostClient(CarPostDto carPostDto, String id){

        restTemplate.put(POST_STOR_SERVICE_URL+"/car/"+id, carPostDto, CarPostDto.class);
    }
    public void carDeletForClient(String id){
        restTemplate.delete(POST_STOR_SERVICE_URL+"/car/");
    }
}
