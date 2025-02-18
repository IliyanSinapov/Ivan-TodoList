package com.iliyansinapov.ivantodolist.repositories;

import com.iliyansinapov.ivantodolist.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, String> {

    // Find a user by email (unique field)
    Optional<User> findByEmail(String email);

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Delete a user by email
    void deleteByEmail(String email);
}