package com.iliyansinapov.ivantodolist.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; // UUID as the primary key

    @Column(nullable = false, length = 255)
    private String description; // Description of the task

    @Column(nullable = false)
    private boolean completed; // Status of the task (completed or not)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_list_id", nullable = false)
    private TodoList todoList; // Many-to-One relationship with TodoList
}
