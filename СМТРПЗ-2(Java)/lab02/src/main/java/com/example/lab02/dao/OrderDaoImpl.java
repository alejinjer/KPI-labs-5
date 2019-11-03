package com.example.lab02.dao;

import com.example.lab02.entity.Order;
import com.example.lab02.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void add(Order order) {
        String sql = "INSERT INTO orders (order_number, id_user, id_product, product_count, creation_date, total_sum) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getOrder_number(), order.getId_user(), order.getId_product(), order.getProduct_count(), order.getCreation_date(), order.getTotalSum());
    }

    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    @Override
    public List<Order> getAllByOrderNumber(Long order_number) {
        String sql = "SELECT * FROM orders WHERE order_number=?";
        return jdbcTemplate.query(sql, new OrderMapper(), order_number);
    }

    @Override
    public Order getById(Long id) {
        String sql = "SELECT * FROM orders WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE orders SET id_user=?, id_product=?, product_count=?, creation_date=?, total_sum=? WHERE order_number=?";
        jdbcTemplate.update(sql, order.getId_user(), order.getId_product(), order.getProduct_count(), order.getCreation_date(), order.getTotalSum());
    }

    @Override
    public void remove(Long order_number) {
        String sql = "DELETE * FROM orders WHERE order_number=?";
        jdbcTemplate.update(sql, order_number);
    }

    @Override
    public void removeById(Long id) {
        String sql = "DELETE * FROM orders WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void createTable() {
        String sql = "create table orders (ID bigint NOT NULL AUTO_INCREMENT, ORDER_NUMBER bigint NOT NULL, ID_USER bigint NOT NULL, ID_PRODUCT bigint NOT NULL, PRODUCT_COUNT int NOT NULL, CREATION_DATE VARCHAR(40), TOTAL_SUM bigint,PRIMARY KEY (ID), FOREIGN KEY (id_user) REFERENCES users (id), FOREIGN KEY (id_product) REFERENCES products (id));";
        jdbcTemplate.execute(sql);
    }

    public void deleteTable() {
        String sql = "DROP TABLE orders";
        jdbcTemplate.execute(sql);
    }
}
