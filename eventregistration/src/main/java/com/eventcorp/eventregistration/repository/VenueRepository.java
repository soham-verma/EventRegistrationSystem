package com.eventcorp.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventcorp.eventregistration.model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}

