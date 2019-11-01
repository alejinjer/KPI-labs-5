package com.example.lab02.dao;

import com.example.lab02.entity.User;

import java.util.List;

public interface UserDao {
    //create
    void add(User user);

    //read
    List<User> getAll();

    User getById(Long id);

    //update
    void update(User user);

    //delete
    void remove(Long id);
}
