package com.example.lab02.dao;

import com.example.lab02.entity.OrderElement;

import java.util.List;

public interface OrderElementDao {

    //create
    void add(OrderElement orderElement);

    //read
    List<OrderElement> getAllByOrderNumber(Long orderNumber);

    OrderElement getById(Long id);

    //update
    void update(OrderElement orderElement);

    //delete
    void remove(Long id);
}
