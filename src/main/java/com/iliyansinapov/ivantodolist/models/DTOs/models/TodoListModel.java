package com.iliyansinapov.ivantodolist.models.DTOs.models;


import com.iliyansinapov.ivantodolist.models.entities.Task;
import com.iliyansinapov.ivantodolist.models.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TodoListModel {
    private String id;
    private String title;
    private LocalDateTime createdAt;
    private List<Task> tasks;
    private User user;
}
