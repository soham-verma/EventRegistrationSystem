package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcorp.eventregistration.model.Payment;
import com.eventcorp.eventregistration.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setPaymentStatus("COMPLETED");
        return paymentRepository.save(payment);
    }
}
