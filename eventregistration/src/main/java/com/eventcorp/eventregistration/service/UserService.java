package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcorp.eventregistration.model.User;
import com.eventcorp.eventregistration.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User userDetails) {
      User user = userRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("User not found"));
  
      user.setName(userDetails.getName());
      user.setEmail(userDetails.getEmail());
      user.setPhone(userDetails.getPhone());
      user.setUsername(userDetails.getUsername());
      user.setPassword(userDetails.getPassword());
  
      return userRepository.save(user);
  }
  
}

