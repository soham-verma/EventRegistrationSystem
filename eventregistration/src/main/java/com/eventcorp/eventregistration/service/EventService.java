package com.eventcorp.eventregistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcorp.eventregistration.dto.PaymentRequest;
import com.eventcorp.eventregistration.dto.PaymentResponse;
import com.eventcorp.eventregistration.dto.UserRequest;
import com.eventcorp.eventregistration.dto.UserResponse;
import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private EventRepository eventRepository;



    @Autowired
    private TicketService ticketService;

    public Event createEvent(Event event) {

        return eventRepository.save(event);
    }


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }


    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));


        event.setName(eventDetails.getName());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        event.setDescription(eventDetails.getDescription());

        return eventRepository.save(event);
    }

    public String registerUserAndProcessPayment(UserRequest userRequest, PaymentRequest paymentRequest) {

        UserResponse userResponse = userService.createUser(userRequest);

        if (userResponse.isSuccess()) {

            Event event = eventRepository.findById(paymentRequest.getEventId())
        .orElse(null);

            if (event == null) {

                return "Event not found";
            }



            event.getRegisteredUsers().add(userResponse.getUser());
            eventRepository.save(event);


            PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);

            if (paymentResponse.isSuccess()) {

                return ticketService.issueTicket(userResponse.getUser().getId(), paymentRequest.getEventId(), paymentResponse.getTransactionId());
            } else {
                return "Payment failed: " + paymentResponse.getMessage();
            }
        } else {
            return "User creation failed: " + userResponse.getMessage();
        }


    }

}
