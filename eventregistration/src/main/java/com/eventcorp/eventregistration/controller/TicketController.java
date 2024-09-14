package com.eventcorp.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventcorp.eventregistration.model.Ticket;
import com.eventcorp.eventregistration.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket issueTicket(@RequestBody Ticket ticket) {
        return ticketService.issueTicket(ticket);
    }
}
