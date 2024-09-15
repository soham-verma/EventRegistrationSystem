package com.eventcorp.eventregistration.controller;

import com.eventcorp.eventregistration.model.Payment;
import com.eventcorp.eventregistration.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public Payment processPayment(@RequestParam Long eventId,
                                  @RequestParam Long userId,
                                  @RequestParam BigDecimal amount) {
        return paymentService.processPayment(eventId, userId, amount);
    }
}
