package com.company.controller;

import com.company.config.Config;
import com.company.entity.Product;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    ProductController(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        productRepository = (ProductRepository) context.getBean("ProductRepository");
    }

    @GetMapping("")
    public List<Product> getProductById(@RequestParam(value = "id", required = false) Integer id) {

        List<Product> resultList = new LinkedList<>();
        if (id == null) {
            resultList = productRepository.findAll();
        }
        else {
            Product product = productRepository.findById(id);
            resultList.add(product);
        }

        return resultList;
    }
}