package com.eventcorp.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcorp.eventregistration.model.Registration;



public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    int countByEventId(Long eventId); // Counts registrations for a specific event
}
