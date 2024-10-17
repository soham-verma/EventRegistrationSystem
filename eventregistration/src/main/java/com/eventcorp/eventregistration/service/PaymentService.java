package com.eventcorp.eventregistration.service;

import com.eventcorp.eventregistration.model.Payment;
import com.eventcorp.eventregistration.dto.*;
import com.eventcorp.eventregistration.model.User;
import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.repository.PaymentRepository;
import com.eventcorp.eventregistration.repository.EventRepository;
import com.eventcorp.eventregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EventRepository eventRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        if ("FAIL".equals(paymentRequest.getPaymentMethod())) {
            return new PaymentResponse(false, "Simulated payment failure", null);
        }

        if ("".equals(paymentRequest.getPaymentMethod())) {
            return new PaymentResponse(false, "Simulated payment failure", null);
        }

        Event event = eventRepository.findById(paymentRequest.getEventId())
                .orElse(null);

        if (event == null) {
            return new PaymentResponse(false, "Event not found", null);
        }



        Payment payment = new Payment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setEvent(event);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setSuccess(true);

        // Save successful payment
        paymentRepository.save(payment);

        return new PaymentResponse(true, "Payment processed", payment.getTransactionId());
    }

    public void processRefundsForEvent(Long eventId) {
        // Fetch all payments for the event
        List<Payment> payments = paymentRepository.findByEventId(eventId);


        for (Payment payment : payments) {
            payment.setSuccess(false);
            paymentRepository.save(payment);
            // Logic to actually process refund (e.g., call a payment gateway)
            System.out.println("Refund processed for transaction: " + payment.getTransactionId());
        }
    }





}


