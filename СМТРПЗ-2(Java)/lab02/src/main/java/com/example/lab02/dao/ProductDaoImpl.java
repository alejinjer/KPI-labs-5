package com.example.lab02.dao;

import com.example.lab02.entity.Product;
import com.example.lab02.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO PRODUCTS (ID, NAME, COST) VALUES(?,?,?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getCost());
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT ID, NAME, COST FROM PRODUCTS";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product getById(Long id) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        return jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE PRODUCTS SET NAME=? COST=? WHERE ID=?";
        jdbcTemplate.update(sql, product.getName(), product.getCost(), product.getId());
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM PRODUCTS WHERE ID=?";
        jdbcTemplate.update(sql, id);
    }

    public void createTable() {
        String sql = "CREATE TABLE users(ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), BIGINT NOT NULL";
        jdbcTemplate.execute(sql);
    }

    public void deleteTable() {
        String sql = "DROP TABLE products";
        jdbcTemplate.execute(sql);
    }
}
