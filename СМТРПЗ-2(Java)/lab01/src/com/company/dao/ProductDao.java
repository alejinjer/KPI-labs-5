package com.company.dao;


import com.company.entity.Product;

import java.util.List;

public interface ProductDao extends AbstractDao<Product> {

    void createTable();

    void deleteTable();

    //create
    void add(Product product);

    //read
    List<Product> getAll();

    Product getById(Long id);

    //update
    void update(Product product);

    //delete
    void remove(Product product);
}
