package com.eventcorp.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventcorp.eventregistration.model.Notification;
import com.eventcorp.eventregistration.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Get all notifications for a specific user
    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsForUser(@PathVariable Long userId) {
        return notificationService.getNotificationsForUser(userId);
    }

    // Send a notification to a user
    @PostMapping
    public Notification sendNotification(@RequestBody Notification notification) {
        // Call the service layer to send the notification
        return notificationService.sendNotification(
            notification.getUserId(), 
            notification.getEventId(), 
            notification.getMessage()
        );
    }
}
