package com.eventcorp.eventregistration.controller;

import com.eventcorp.eventregistration.dto.TicketRequest;
import com.eventcorp.eventregistration.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Endpoint to issue a ticket
    @PostMapping("/issue")
    public ResponseEntity<String> issueTicket(@RequestBody TicketRequest ticketRequest) {
        String result = ticketService.issueTicket(ticketRequest.getUserId(), ticketRequest.getEventId(), ticketRequest.getTransactionId());
        return ResponseEntity.ok(result); // Returning success message from TicketService
    }
}
