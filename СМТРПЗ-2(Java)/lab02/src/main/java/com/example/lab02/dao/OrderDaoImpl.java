package com.example.lab02.dao;

import com.example.lab02.entity.Order;
import com.example.lab02.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void add(Order order) {
        String sql = "INSERT INTO orders (order_number, id_user, creation_date, total_sum, pay_status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getOrderNumber(), order.getId_user(), order.getCreationDate(), order.getTotalSum(), order.getPayStatus());
    }

    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    @Override
    public Order getById(Long id) {
        String sql = "SELECT * FROM orders WHERE order_number=?";
        return jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE orders SET id_user=?, creation_date=?, total_sum=?, pay_status=? WHERE order_number=?";
        jdbcTemplate.update(sql, order.getId_user(), order.getCreationDate(), order.getTotalSum(), order.getPayStatus());
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM orders WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void createTable() {
        String sql = "CREATE TABLE orders (order_number BIGINT AUTO_INCREMENT, id_user BIGINT NOT NULL, creation_date VARCHAR(40), total_sum BIGINT, pay_status BOOLEAN, PRIMARY KEY (order_number), FOREIGN KEY (id_user) REFERENCES users (id));";
        jdbcTemplate.execute(sql);
    }

    public void deleteTable() {
        String sql = "DROP TABLE orders";
        jdbcTemplate.execute(sql);
    }
}
