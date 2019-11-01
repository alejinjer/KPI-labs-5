package com.example.lab02.mapper;

import com.example.lab02.entity.OrderElement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderElementMapper implements RowMapper<OrderElement> {
    public OrderElement mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderElement orderElement = new OrderElement();
        orderElement.setId(resultSet.getLong("id"));
        orderElement.setOrderNumber(resultSet.getLong("order_number"));
        orderElement.setProductId(resultSet.getLong("id_product"));
        orderElement.setProductCount(resultSet.getInt("count_product"));
        return orderElement;
    }
}
