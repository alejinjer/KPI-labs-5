package com.example.lab02.controller;

import com.example.lab02.entity.User;
import com.example.lab02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    //create
    @PostMapping("/users")
    public User addUser(@RequestBody @RequestParam(value = "id", required = false) Long id,
                        @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "address", required = false) String address) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        userService.add(user);
        return user;
    }

    //read
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    //update
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "address", required = false) String address) {
        User user = userService.getById(id);
        user.setName(name);
        user.setAddress(address);
        userService.update(user);
    }

    //delete
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.remove(id);
    }
}

