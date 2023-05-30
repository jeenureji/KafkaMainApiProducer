package com.microservice.kafka.mainapi.controller;


import com.microservice.kafka.mainapi.dto.CarPostDto;
import com.microservice.kafka.mainapi.message.KafkaProducerMessage;
import com.microservice.kafka.mainapi.service.CarPostStorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostStorService carPostStorService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;


    @PostMapping("/post")
    public ResponseEntity postCarForSail(@RequestBody CarPostDto carPostDto){
        kafkaProducerMessage.sendMessage(carPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDto>> getCarForSale(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStorService.getCarForSale());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable String id){
        carPostStorService.changeCarForSale(carPostDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarSale(@PathVariable String id){
        carPostStorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
