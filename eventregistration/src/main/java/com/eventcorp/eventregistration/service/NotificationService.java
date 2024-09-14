package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcorp.eventregistration.model.Notification;
import com.eventcorp.eventregistration.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsForUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Notification sendNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}
