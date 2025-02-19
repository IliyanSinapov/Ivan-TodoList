package com.iliyansinapov.ivantodolist.models.DTOs;

import com.iliyansinapov.ivantodolist.models.TodoList;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskModel {
    private String id;
    private boolean completed;
    private TodoList todoList;
}
