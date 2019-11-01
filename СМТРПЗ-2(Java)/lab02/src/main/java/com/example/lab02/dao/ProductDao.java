package com.example.lab02.dao;

import com.example.lab02.entity.Product;

import java.util.List;

public interface ProductDao {

    //create
    void add(Product product);

    //read
    List<Product> getAll();

    Product getById(Long id);

    //update
    void update(Product product);

    //delete
    void remove(Long id);
}
