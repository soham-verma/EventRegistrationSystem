package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcorp.eventregistration.model.Ticket;
import com.eventcorp.eventregistration.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket issueTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}

