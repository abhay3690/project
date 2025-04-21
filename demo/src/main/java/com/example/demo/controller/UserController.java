package com.example.demo.controller;

import com.example.demo.dto.TodoDto;
import com.example.demo.model.User;
import com.example.demo.service.TodoClientService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    //inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    //expose new endPoints for "teamInfo"
    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+ ", TeamName: "+teamName;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private TodoClientService todoClientService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @PostMapping
    public User newUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/todo")
    public List<TodoDto> getTodos() {
        return todoClientService.getAllTodos();
    }


}
