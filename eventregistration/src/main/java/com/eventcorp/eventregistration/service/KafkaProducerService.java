package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserInteraction(String eventId, String interactionType) {
        String message = String.format("Event: %s, Interaction: %s", eventId, interactionType);
            kafkaTemplate.send("event-popularity-topic", message);
            System.out.println("Sent message: " + message);
    }
}
