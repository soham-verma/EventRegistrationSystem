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

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EventRepository eventRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        Event event = eventRepository.findById(paymentRequest.getEventId())
        .orElse(null);


        Payment payment = new Payment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setEvent(event);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setSuccess(true);


        paymentRepository.save(payment);


        return new PaymentResponse(true, "Payment processed", payment.getTransactionId());
    }
}


