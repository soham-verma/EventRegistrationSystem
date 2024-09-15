package com.eventcorp.eventregistration.service;

import com.eventcorp.eventregistration.model.Payment;
import com.eventcorp.eventregistration.model.User;
import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.repository.PaymentRepository;
import com.eventcorp.eventregistration.repository.EventRepository;
import com.eventcorp.eventregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Payment processPayment(Long eventId, Long userId, BigDecimal amount) {
        // Fetch event and user
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create a new payment
        Payment payment = new Payment();
        payment.setEvent(event);
        payment.setUser(user);
        payment.setAmount(amount);
        payment.setPaymentStatus("COMPLETED");

        return paymentRepository.save(payment);
    }
}
