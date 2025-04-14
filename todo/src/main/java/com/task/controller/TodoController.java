package com.task.controller;

import com.task.model.Todo;
import com.task.service.TodoSetvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoSetvice todoSetvice;

    @GetMapping
    public ResponseEntity<List<Todo>> findALlTask(){
        List<Todo> allTasks = todoSetvice.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> createTask(@RequestBody Todo todo){
        Todo createdTask = todoSetvice.createTask(todo);
        return new ResponseEntity<>(createdTask,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTask(@PathVariable int id, @RequestBody Todo todo){
        Todo updateTask = todoSetvice.updateTask(id, todo);
        return new ResponseEntity<>(updateTask,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTaskById(@PathVariable int id){
        Todo taskById = todoSetvice.getTaskById(id);
        return new ResponseEntity<>(taskById,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable int id){
        boolean b = todoSetvice.deleteTask(id);
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
}
