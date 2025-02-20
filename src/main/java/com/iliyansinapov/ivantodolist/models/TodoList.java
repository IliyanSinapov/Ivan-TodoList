package com.iliyansinapov.ivantodolist.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "todo_lists")
public class TodoList {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; // UUID as the primary key

    @Column(nullable = false, length = 255)
    private String title; // Title of the todo list

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // Automatically set in the backend

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks; // One-to-Many relationship with Task

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many-to-One relationship with User

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now(); // Automatically set the creation timestamp
    }
}

