package com.eventcorp.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventcorp.eventregistration.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {}
