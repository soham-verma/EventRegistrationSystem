package com.eventcorp.eventregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.model.User;
import com.eventcorp.eventregistration.repository.EventRepository;

@Service
public class OrganizerService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getOrganizerEvents(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public Event createEvent(Event event, Long organizerId) {
        User organizer = new User();  // Assuming user service exists to fetch organizer by ID
        organizer.setId(organizerId);
        event.setOrganizer(organizer);
        return eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}

