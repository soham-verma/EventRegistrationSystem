package com.eventcorp.eventregistration.controller;

import com.eventcorp.eventregistration.dto.CombinedRequest;
import com.eventcorp.eventregistration.dto.PaymentRequest;
import com.eventcorp.eventregistration.dto.UserRequest;
import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    // Get all events
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        return ResponseEntity.ok(event);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event updatedEvent = eventService.updateEvent(id, eventDetails);
        return ResponseEntity.ok(updatedEvent);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancelEvent(@PathVariable Long id) {
        String response = eventService.cancelEvent(id);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUserAndProcessPayment(@RequestBody CombinedRequest combinedRequest) {
        UserRequest userRequest = combinedRequest.getUserRequest();
        PaymentRequest paymentRequest = combinedRequest.getPaymentRequest();

        String response = eventService.registerUserAndProcessPayment(userRequest, paymentRequest);
        return ResponseEntity.ok(response);
    }
}
