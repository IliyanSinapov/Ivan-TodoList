package com.iliyansinapov.ivantodolist.models.DTOs.models;

import com.iliyansinapov.ivantodolist.models.entities.TodoList;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskModel {
    private String id;
    private boolean completed;
    private TodoList todoList;
}
