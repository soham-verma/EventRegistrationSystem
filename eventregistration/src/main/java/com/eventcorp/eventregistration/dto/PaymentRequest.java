package com.eventcorp.eventregistration.dto;

public class PaymentRequest {
    private Long userId;
    private Long eventId;
    private Double amount;
    private String paymentMethod;

    // Constructors, Getters, and Setters

    public PaymentRequest() {}

    public PaymentRequest(Long userId, Long eventId, Double amount, String paymentMethod) {
        this.userId = userId;
        this.eventId = eventId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
