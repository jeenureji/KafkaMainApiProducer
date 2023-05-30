package com.microservice.kafka.mainapi.message;

import com.microservice.kafka.mainapi.dto.CarPostDto;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Component
public class kafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-service}")
    private String bootStrapService;

    @Bean
    public ProducerFactory<String, CarPostDto> producerFactory (){
        Map<String, Object> carPostDtoMap = new HashMap<>();
        carPostDtoMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapService);
        carPostDtoMap.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        carPostDtoMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        carPostDtoMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class.getName());

        return new DefaultKafkaProducerFactory<>(carPostDtoMap);
    }

    @Bean
    public KafkaTemplate<String, CarPostDto> userKafkaTamplet(){
        return new KafkaTemplate<>(producerFactory());

    }

}
