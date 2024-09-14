package com.eventcorp.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.servlet.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    int countByEventId(Long eventId); // Counts registrations for a specific event
}
