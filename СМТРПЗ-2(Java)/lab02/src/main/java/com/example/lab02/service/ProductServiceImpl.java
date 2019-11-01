package com.example.lab02.service;

import com.example.lab02.dao.ProductDao;
import com.example.lab02.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    public ProductDao productDao;

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void remove(Long id) {
        productDao.remove(id);
    }
}
