package com.eventcorp.eventregistration.model;


import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

    private String ticketType; // e.g., VIP, General
    private double price;
    private String seatNumber;

    // Getters and Setters
}
