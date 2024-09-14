package com.eventcorp.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventcorp.eventregistration.model.Notification;

import java.util.List;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Custom query to find notifications by user ID
    List<Notification> findByUserId(Long userId);
}