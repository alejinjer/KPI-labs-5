package com.example.lab02.mapper;

import com.example.lab02.entity.Order;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order orderElement = new Order();
        orderElement.setOrderNumber(resultSet.getLong("order_number"));
        orderElement.setId_user(resultSet.getLong("id_user"));
        orderElement.setCreationDate(resultSet.getDate("creation_date"));
        orderElement.setTotalSum(resultSet.getLong("total_sum"));
        orderElement.setPayStatus(resultSet.getBoolean("pay_status"));
        return orderElement;
    }
}
