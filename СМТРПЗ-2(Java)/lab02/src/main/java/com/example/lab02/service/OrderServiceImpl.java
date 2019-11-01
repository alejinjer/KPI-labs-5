package com.example.lab02.service;

import com.example.lab02.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderService orderService;

    @Override
    public void add(Order order) {
        orderService.add(order);
    }

    @Override
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @Override
    public Order getById(Long id) {
        return orderService.getById(id);
    }

    @Override
    public void update(Order order) {
        orderService.update(order);
    }

    @Override
    public void remove(Long id) {
        orderService.remove(id);
    }
}
