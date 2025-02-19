package com.iliyansinapov.ivantodolist.models.DTOs;


import com.iliyansinapov.ivantodolist.models.Task;
import com.iliyansinapov.ivantodolist.models.User;
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
