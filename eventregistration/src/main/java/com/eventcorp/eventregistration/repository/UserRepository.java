package com.eventcorp.eventregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eventcorp.eventregistration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.organizedEvents e WHERE e.id = :eventId")
    List<User> findUsersByEventId(@Param("eventId") Long eventId);
}

