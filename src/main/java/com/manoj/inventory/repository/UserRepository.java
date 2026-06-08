package com.manoj.inventory.repository;

import com.manoj.inventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    // ADDED FOR LOGIN
    Optional<User> findByEmail(String email);
}