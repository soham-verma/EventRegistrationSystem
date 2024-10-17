package com.eventcorp.eventregistration.service;

import com.eventcorp.eventregistration.model.Notification;
import com.eventcorp.eventregistration.model.User;
import com.eventcorp.eventregistration.repository.NotificationRepository;
import com.eventcorp.eventregistration.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Notification> getNotificationsForUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }


    public Notification sendNotification(Notification notification) {
        notification.setSentDate(java.time.LocalDateTime.now());  // Set the current date and time
        return notificationRepository.save(notification);
    }

    public void notifyUsersOfCancellation(Long eventId) {
        // Fetch all users registered for the event
        List<User> registeredUsers = userRepository.findUsersByEventId(eventId);

        // Notify each user about the event cancellation
        for (User user : registeredUsers) {
            // Logic to send notification (e.g., email or SMS)
            System.out.println("Notification sent to user: " + user.getEmail());
        }
    }
}
