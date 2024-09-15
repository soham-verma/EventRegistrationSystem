package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventSearchService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> searchEventsByName(String name) {
        return eventRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Event> searchEventsByDate(String date) {
    // Convert the String date to LocalDate
    LocalDate eventDate = LocalDate.parse(date);

    // Pass the LocalDate to the repository method
    return eventRepository.findByDate(eventDate);
}

    public List<Event> searchEventsByLocation(String location) {
        return eventRepository.findByLocationContainingIgnoreCase(location);
    }
}
