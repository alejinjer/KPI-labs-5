package com.example.lab02.service;

import com.example.lab02.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);

    //read
    List<User> getAll();

    User getById(Long id);

    //update
    void update(User user);

    //delete
    void remove(Long id);
}
