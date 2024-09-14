package com.eventcorp.eventregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcorp.eventregistration.model.Event;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainingIgnoreCase(String name);
    List<Event> findByDate(String date);
    List<Event> findByLocationContainingIgnoreCase(String location);
}

