package com.example.lab02.dao;

import com.example.lab02.entity.Order;

import java.util.List;

public interface OrderDao {
    //create
    void add(Order order);

    //read
    List<Order> getAll();

    Order getById(Long id);

    //update
    void update(Order order);

    //delete
    void remove(Long id);
}
