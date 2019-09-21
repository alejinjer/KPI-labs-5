package com.company.dao;

import com.company.entity.Order;

import java.util.List;

public interface OrderDao extends AbstractDao<Order> {

    void createTable();

    void deleteTable();

    //create
    void add(Order order);

    //read
    List<Order> getAll();

    Order getById(Long id);

    //update
    void update(Order order);

    //delete
    void remove(Order order);
}
