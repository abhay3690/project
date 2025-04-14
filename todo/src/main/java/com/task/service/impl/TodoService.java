package com.task.service.impl;

import com.task.model.Todo;
import com.task.repository.TodoRepo;
import com.task.service.TodoSetvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService implements TodoSetvice {
    private static final String NOTFOUND = "todo not found";

    @Autowired
    private TodoRepo todoRepo;

    @Override
    public List<Todo> getAllTasks() {
        return todoRepo.findAll();
    }

    @Override
    public Todo createTask(Todo todo) {
        return todoRepo.save(todo);
    }

    @Override
    public boolean deleteTask(int id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new RuntimeException(NOTFOUND));
        todoRepo.delete(todo);
        return true;
    }

    @Override
    public Todo updateTask(int id, Todo todo) {
        Todo todo1 = todoRepo.findById(id).orElseThrow(() -> new RuntimeException(NOTFOUND));
        if(todo1.getTitle() != null){
            todo1.setTitle(todo.getTitle());
        }
        todo1.setCompleted(todo.isCompleted());
        return todo1;
    }

    @Override
    public Todo getTaskById(int id) {
        return todoRepo.findById(id).orElseThrow(()-> new RuntimeException(NOTFOUND));
    }
}
