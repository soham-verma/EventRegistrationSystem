package com.eventcorp.eventregistration.repository;

import com.eventcorp.eventregistration.model.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.event.id = :eventId")
    Double calculateTotalRevenueByEventId(Long eventId);
    List<Payment> findByEventId(Long eventId);
}
