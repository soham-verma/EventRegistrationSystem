package com.eventcorp.eventregistration.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PopularityService {

    private final Map<String, Integer> eventPopularityMap = new HashMap<>();

    // Method to update event popularity
    public void updatePopularity(String eventId, String interactionType) {
        eventPopularityMap.put(eventId, eventPopularityMap.getOrDefault(eventId, 0) + 1);
    }

    // Method to get all event popularity statistics
    public Map<String, Integer> getAllEventPopularity() {
        return eventPopularityMap;
    }

    // Method to get the popularity of a specific event
    public int getEventPopularity(String eventId) {
        return eventPopularityMap.getOrDefault(eventId, 0);
    }
}
