package com.company.service;

import com.company.Util;
import com.company.dao.OrderDao;
import com.company.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCOrderDao extends Util implements OrderDao {

    private String sqlCreateTable = "create table orders (ID bigint NOT NULL, USER_ID bigint NOT NULL, PRODUCT_ID bigint NOT NULL, CONSTRAINT ID PRIMARY KEY (ID));";
    private String sqlDeleteTable = "drop table orders";

    private Connection connection = getMySQLConnection();

    @Override
    public void add(Order order) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ORDERS (ID, USER_ID, PRODUCT_ID) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, order.getId());
            preparedStatement.setLong(2, order.getUserId());
            preparedStatement.setLong(3, order.getProductId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT ID, USER_ID, PRODUCT_ID FROM ORDERS";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Order product = new Order();
                product.setId(resultSet.getLong("ID"));
                product.setUserId(resultSet.getLong("USER_ID"));
                product.setProductId(resultSet.getLong("PRODUCT_ID"));

                orderList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order getById(Long id) {
        PreparedStatement preparedStatement = null;

        Order order = new Order();

        String sql = "SELECT * FROM ORDERS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            order.setId(resultSet.getLong("ID"));
            order.setUserId(resultSet.getLong("USER_ID"));
            order.setProductId(resultSet.getLong("PRODUCT_ID"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void update(Order order) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE ORDERS SET USER_ID=?, PRODUCT_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, order.getUserId());
            preparedStatement.setLong(2, order.getProductId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Order order) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ORDERS WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, order.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(this.sqlCreateTable);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTable() {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(this.sqlDeleteTable);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
