package com.example.lab02.service;

import com.example.lab02.entity.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);

    //read
    List<Product> getAll();

    Product getById(Long id);

    //update
    void update(Product product);

    //delete
    void remove(Long id);
}
