package com.iliyansinapov.ivantodolist.repositories;

import com.iliyansinapov.ivantodolist.models.entities.Task;
import com.iliyansinapov.ivantodolist.models.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, String> {


}
