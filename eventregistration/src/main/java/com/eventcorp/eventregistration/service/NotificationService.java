package com.eventcorp.eventregistration.service;

import com.eventcorp.eventregistration.model.Notification;
import com.eventcorp.eventregistration.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Fetch notifications for a specific user
    public List<Notification> getNotificationsForUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Send a notification
    public Notification sendNotification(Notification notification) {
        notification.setSentDate(java.time.LocalDateTime.now());  // Set the current date and time
        return notificationRepository.save(notification);
    }
}
