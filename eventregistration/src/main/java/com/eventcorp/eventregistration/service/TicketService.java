package com.eventcorp.eventregistration.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcorp.eventregistration.model.Ticket;
import com.eventcorp.eventregistration.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public String issueTicket(Long userId, Long eventId, String transactionId) {
        Ticket ticket = new Ticket();
        ticket.setUserId(userId);
        ticket.setEventId(eventId);
        ticket.setTicketNumber(UUID.randomUUID().toString()); // Generate ticket number
        ticketRepository.save(ticket);

        return "Ticket issued successfully!";
    }
}


