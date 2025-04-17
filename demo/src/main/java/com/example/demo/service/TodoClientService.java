package com.example.demo.service;

import com.example.demo.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoClientService {

    @Autowired
    private RestTemplate restTemplate;

    public List<TodoDto> getAllTodos() {
        ResponseEntity<TodoDto[]> response = restTemplate.getForEntity(
                "http://localhost:8081/todo",
                TodoDto[].class
        );

        TodoDto[] todos = response.getBody();
        return todos != null ? Arrays.asList(todos) : new ArrayList<>();
    }
}
