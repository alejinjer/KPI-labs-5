package com.example.lab02.dao;

import com.example.lab02.entity.OrderElement;
import com.example.lab02.mapper.OrderElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderElementDaoImpl implements OrderElementDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void add(OrderElement orderElement) {
        String sql = "INSERT INTO order_elements (id, order_number, id_product, count_product) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderElement.getId(), orderElement.getOrderNumber(), orderElement.getProductId(), orderElement.getProductCount());
    }

    @Override
    public List<OrderElement> getAllByOrderNumber(Long orderNumber) {
        String sql = "SELECT * FROM order_elements WHERE order_number=?";
        return jdbcTemplate.query(sql, new OrderElementMapper(), orderNumber);
    }

    @Override
    public OrderElement getById(Long id) {
        String sql = "SELECT * FROM order_elements WHERE ID=?";
        return jdbcTemplate.queryForObject(sql, new OrderElementMapper(), id);
    }

    @Override
    public void update(OrderElement orderElement) {
        String sql = "UPDATE order_elements SET id_product=? count_product=? WHERE ID=?";
        jdbcTemplate.update(sql, orderElement.getProductId(), orderElement.getProductCount());
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM order_elements WHERE ID=?";
        jdbcTemplate.update(sql, id);
    }

    public void createTable() {
        String sql = "CREATE TABLE order_elements ( id BIGINT AUTO_INCREMENT, order_number BIGINT NOT NULL, id_product BIGINT NOT NULL, count_product INTEGER NOT NULL, PRIMARY KEY (id), FOREIGN KEY (order_number) REFERENCES orders (order_number) ON DELETE CASCADE, FOREIGN KEY (id_product) REFERENCES products (id) );";
        jdbcTemplate.execute(sql);
    }

    public void deleteTable() {
        String sql = "DROP TABLE order_elements";
        jdbcTemplate.execute(sql);
    }
}
