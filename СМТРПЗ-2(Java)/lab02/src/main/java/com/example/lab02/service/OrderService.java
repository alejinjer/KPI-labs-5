package com.example.lab02.service;

import com.example.lab02.entity.Order;

import java.util.List;

public interface OrderService {
    //create
    void add(Order order);

    //read
    List<Order> getAll();

    List<Order> getAllByOrderNumber(Long order_number);

    Order getById(Long id);
    //update
    void update(Order order);

    //delete
    void remove(Long order_number);

    void removeById(Long id);
}
