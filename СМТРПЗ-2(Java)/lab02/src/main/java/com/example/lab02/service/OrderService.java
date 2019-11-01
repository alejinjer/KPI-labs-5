package com.example.lab02.service;

import com.example.lab02.entity.Order;

import java.util.List;

public interface OrderService {
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
