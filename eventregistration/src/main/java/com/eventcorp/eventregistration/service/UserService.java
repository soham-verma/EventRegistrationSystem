package com.eventcorp.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcorp.eventregistration.dto.UserRequest;
import com.eventcorp.eventregistration.dto.UserResponse;
import com.eventcorp.eventregistration.model.User;
import com.eventcorp.eventregistration.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setPassword(userRequest.getPassword());


        User savedUser = userRepository.save(user);


        return new UserResponse(true, "User created successfully", savedUser);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
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


