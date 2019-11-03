package com.example.lab02.service;

import com.example.lab02.dao.OrderDao;
import com.example.lab02.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderDao orderDao;

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public List<Order> getAllByOrderNumber(Long order_number) {
        return orderDao.getAllByOrderNumber(order_number);
    }

    @Override
    public Order getById(Long id) {
        return orderDao.getById(id);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void remove(Long order_number) {
        orderDao.remove(order_number);
    }

    @Override
    public void removeById(Long id) {
        orderDao.removeById(id);
    }
}
