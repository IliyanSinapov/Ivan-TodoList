package com.iliyansinapov.ivantodolist.services;

import com.iliyansinapov.ivantodolist.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // Find a user by email (unique field)
    Optional<User> findByEmail(String email);

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Delete a user by email
    void deleteByEmail(String email);

    // Find users by first name and last name (custom query)
    @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // Count users created after a specific date (custom query)
    @Query("SELECT COUNT(u) FROM User u WHERE u.createdAt > :date")
    long countByCreatedAtAfter(@Param("date") LocalDateTime date);

    // Find users with at least one to-do list (custom query)
    @Query("SELECT u FROM User u WHERE SIZE(u.todoLists) > 0")
    List<User> findUsersWithTodoLists();
}
