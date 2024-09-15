package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcorp.eventregistration.model.EventReport;
import com.eventcorp.eventregistration.repository.PaymentRepository;
import com.eventcorp.eventregistration.repository.RegistrationRepository;

@Service
public class ReportService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public EventReport generateEventReport(Long eventId) {
        // Get total number of registrations
        int totalRegistrations = registrationRepository.countByEventId(eventId);

        // Get total revenue for the event
        Double totalRevenue = paymentRepository.calculateTotalRevenueByEventId(eventId);

        // Ensure the revenue is not null (in case there are no payments yet)
        if (totalRevenue == null) {
            totalRevenue = 0.0;
        }

        // Return the event report with total registrations and revenue
        return new EventReport(totalRegistrations, totalRevenue);
    }
}
