package com.iliyansinapov.ivantodolist.repositories;

import com.iliyansinapov.ivantodolist.models.entities.TodoList;
import com.iliyansinapov.ivantodolist.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, String> {

    // Find all TodoLists by User ID
    List<TodoList> findByUserId(String userId);

    // Find a TodoList by its ID and User ID (to ensure the user owns the TodoList)
    Optional<TodoList> findByIdAndUserId(String id, String userId);

    // Delete all TodoLists by User ID
    void deleteByUserId(String userId);

    // Find TodoLists by User ID and Title (custom query)
    @Query("SELECT t FROM TodoList t WHERE t.user.id = :userId AND t.title = :title")
    List<TodoList> findByUserIdAndTitle(@Param("userId") String userId, @Param("title") String title);

    // Count TodoLists for a User (custom query)
    @Query("SELECT COUNT(t) FROM TodoList t WHERE t.user.id = :userId")
    long countByUserId(@Param("userId") String userId);

    // Find TodoLists created after a specific date (custom query)
    @Query("SELECT t FROM TodoList t WHERE t.user.id = :userId AND t.createdAt > :date")
    List<TodoList> findByUserIdAndCreatedAtAfter(@Param("userId") String userId, @Param("date") LocalDateTime date);
}
