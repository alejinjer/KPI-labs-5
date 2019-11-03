package com.example.lab02.controller;

import com.example.lab02.entity.Order;
import com.example.lab02.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //create
    @PostMapping("/orders")
    public Order createOrder(@RequestBody @RequestParam(value = "order_number", required = true) Long order_number,
                             @RequestParam(value = "id_user", required = true) Long id_user,
                             @RequestParam(value = "id_product", required = true) Long id_product,
                             @RequestParam(value = "product_count", required = false) int product_count,
                             @RequestParam(value = "creation_date", required = false) Date creation_date,
                             @RequestParam(value = "total_sum", required = false) Long total_sum) {
        Order order = new Order();
        order.setOrder_number(order_number);
        order.setId_user(id_user);
        order.setId_product(id_product);
        order.setProduct_count(product_count);
        order.setCreation_date(creation_date);
        order.setTotalSum(total_sum);
        orderService.add(order);
        return order;
    }

    //read
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/orders/{order_number}")
    public List<Order> getOrderByOrderNumber(@PathVariable Long order_number) {
        return orderService.getAllByOrderNumber(order_number);
    }

    //update
    @PutMapping("/orders/{id}")
    public void updateOrder(@PathVariable Long id,
                            @RequestParam(value = "order_number", required = true) Long order_number,
                            @RequestParam(value = "id_user", required = true) Long id_user,
                            @RequestParam(value = "id_product", required = true) Long id_product,
                            @RequestParam(value = "product_count", required = false) int product_count,
                            @RequestParam(value = "creation_date", required = true) Date creation_date,
                            @RequestParam(value = "total_sum", required = false) Long total_sum) {
        Order order = orderService.getById(id);
        order.setOrder_number(order_number);
        order.setId_user(id_user);
        order.setId_product(id_product);
        order.setProduct_count(product_count);
        order.setCreation_date(creation_date);
        order.setTotalSum(total_sum);
        orderService.update(order);
    }

    //delete
    @DeleteMapping("/orders/{order_number}")
    public void deleteOrdersByOrderNumber(@PathVariable Long order_number) {
        orderService.remove(order_number);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.removeById(id);
    }
}
