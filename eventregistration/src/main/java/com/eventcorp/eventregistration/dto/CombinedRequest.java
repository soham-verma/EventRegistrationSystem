package com.eventcorp.eventregistration.dto;

public class CombinedRequest {
    private UserRequest userRequest;
    private PaymentRequest paymentRequest;

    // Getters and Setters
    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }
}
