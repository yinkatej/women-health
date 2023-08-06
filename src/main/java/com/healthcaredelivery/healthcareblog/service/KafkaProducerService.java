package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Blog> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Blog> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String topic, Blog blogMessage){
        kafkaTemplate.send(topic, blogMessage);
    }
}
