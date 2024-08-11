package com.eventcorp.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcorp.eventregistration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}

