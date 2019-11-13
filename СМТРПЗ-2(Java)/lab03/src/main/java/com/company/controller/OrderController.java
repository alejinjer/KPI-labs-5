package com.company.controller;

import com.company.entity.Order;
import com.company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("")
    public List<Order> getAllOrders() {
        List<Order> resultList = new ArrayList<>();

        Iterable<Order> result = orderRepository.findAll();
        result.forEach(resultList::add);
        return resultList;
    }

}
