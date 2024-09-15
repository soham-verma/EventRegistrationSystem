package com.eventcorp.eventregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.service.OrganizerService;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @GetMapping("/organizers/{organizerId}/events")
    public List<Event> getOrganizerEvents(@PathVariable Long organizerId) {
        return organizerService.getOrganizerEvents(organizerId);
    }

    @PostMapping("/{organizerId}/events")
    public ResponseEntity<Event> createEvent(@PathVariable Long organizerId, @RequestBody Event event) {
        Event createdEvent = organizerService.createEvent(event, organizerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        organizerService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
