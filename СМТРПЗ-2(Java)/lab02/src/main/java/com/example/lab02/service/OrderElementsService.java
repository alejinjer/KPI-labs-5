package com.example.lab02.service;

import com.example.lab02.entity.OrderElement;

import java.util.List;

public interface OrderElementsService {
    //create
    void add(OrderElement orderElement);

    //read
    List<OrderElement> getAllByOrderNumber(Long userId);

    OrderElement getById(Long id);

    //update
    void update(OrderElement orderElement);

    //delete
    void remove(Long id);
}
