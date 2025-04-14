package com.task.service;

import com.task.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoSetvice {
    List<Todo> getAllTasks();
    Todo createTask(Todo todo);
    boolean deleteTask(int id);
    Todo updateTask(int id, Todo todo);
    Todo getTaskById(int id);

}
