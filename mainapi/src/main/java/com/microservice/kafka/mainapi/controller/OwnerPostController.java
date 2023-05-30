package com.microservice.kafka.mainapi.controller;

import com.microservice.kafka.mainapi.dto.OwnerPostDto;
import com.microservice.kafka.mainapi.service.OwnerPostStorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    @Autowired
    OwnerPostStorService ownerPostStorService;

    @PostMapping
    public ResponseEntity ownerPost(@RequestBody OwnerPostDto ownerPostDto){
        ownerPostStorService.postOwner(ownerPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
