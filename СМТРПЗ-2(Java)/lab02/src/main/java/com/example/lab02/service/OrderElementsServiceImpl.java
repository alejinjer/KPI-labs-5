package com.example.lab02.service;

import com.example.lab02.dao.OrderElementDao;
import com.example.lab02.entity.OrderElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderElementsServiceImpl implements OrderElementsService {

    @Autowired
    public OrderElementDao orderElementDao;


    @Override
    public void add(OrderElement orderElement) {
        orderElementDao.add(orderElement);
    }

    @Override
    public List<OrderElement> getAllByOrderNumber(Long orderNumber) {
        return orderElementDao.getAllByOrderNumber(orderNumber);
    }

    @Override
    public OrderElement getById(Long id) {
        return orderElementDao.getById(id);
    }

    @Override
    public void update(OrderElement orderElement) {
        orderElementDao.update(orderElement);
    }

    @Override
    public void remove(Long id) {
        orderElementDao.remove(id);
    }
}
