package com.example.lab02.mapper;

import com.example.lab02.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order orderElement = new Order();
        orderElement.setOrder_number(resultSet.getLong("order_number"));
        orderElement.setId_user(resultSet.getLong("id_user"));
        orderElement.setId_product(resultSet.getLong("id_product"));
        orderElement.setProduct_count(resultSet.getInt("product_count"));
        orderElement.setCreation_date(resultSet.getDate("creation_date"));
        orderElement.setTotalSum(resultSet.getLong("total_sum"));
        return orderElement;
    }
}
