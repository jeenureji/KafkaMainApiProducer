package com.microservice.kafka.mainapi.message;

import com.microservice.kafka.mainapi.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDto> kafkaTemplate;

    public final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDto carPostDto){
        kafkaTemplate.send(KAFKA_TOPIC, carPostDto);
    }
}
