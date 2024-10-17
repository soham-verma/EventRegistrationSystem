package com.eventcorp.eventregistration.service;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    // In-memory storage for event popularity metrics
    private ConcurrentHashMap<String, EventPopularity> eventPopularityMap = new ConcurrentHashMap<>();

    @KafkaListener(topics = "event-popularity-topic", groupId = "event-popularity-group")
    public void consume(String message) {
        try {
            // Assuming you are splitting the message by a delimiter
            String[] parts = message.split(":");

            // Check if the expected number of parts is present
            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid message format: " + message);
            }

            String eventDetails = parts[0];
            String interaction = parts[1];

            // Further processing
            System.out.println("Received message: Event: " + eventDetails + ", Interaction: " + interaction);
        } catch (Exception e) {
            // Log and handle the exception
            System.err.println("Error processing Kafka message: " + message);
            e.printStackTrace();
        }
    }


    // Method to update the event popularity based on the interaction type
    private void updateEventPopularity(String eventId, String interactionType) {
        eventPopularityMap.computeIfAbsent(eventId, id -> new EventPopularity());

        EventPopularity eventPopularity = eventPopularityMap.get(eventId);

        switch (interactionType) {
            case "REGISTERED":
                eventPopularity.incrementRegistrations();
                break;
            case "LIKED":
                eventPopularity.incrementLikes();
                break;
            default:
                System.out.println("Unknown interaction type: " + interactionType);
                return;
        }

        System.out.println("Updated event " + eventId + " - " + eventPopularity);
    }

    // EventPopularity class to hold the counts of registrations and likes
    private static class EventPopularity {
        private AtomicInteger registrations = new AtomicInteger(0);
        private AtomicInteger likes = new AtomicInteger(0);

        public void incrementRegistrations() {
            registrations.incrementAndGet();
        }

        public void incrementLikes() {
            likes.incrementAndGet();
        }

        @Override
        public String toString() {
            return "Registrations: " + registrations.get() + ", Likes: " + likes.get();
        }
    }
}
