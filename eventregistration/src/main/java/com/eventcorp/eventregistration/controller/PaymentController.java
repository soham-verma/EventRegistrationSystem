package com.eventcorp.eventregistration.controller;

import com.eventcorp.eventregistration.dto.PaymentRequest;
import com.eventcorp.eventregistration.dto.PaymentResponse;
import com.eventcorp.eventregistration.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(paymentResponse); // Returning PaymentResponse object
    }
}
