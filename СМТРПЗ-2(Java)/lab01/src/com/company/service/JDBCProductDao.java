package com.company.service;

import com.company.Util;
import com.company.dao.ProductDao;
import com.company.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductDao extends Util implements ProductDao {

    private String sqlCreateTable = "create table products (ID bigint NOT NULL, NAME character varying(255) NOT NULL, COST bigint NOT NULL, CONSTRAINT ID PRIMARY KEY (ID));";
    private String sqlDeleteTable = "drop table products";
    private Connection connection = getMySQLConnection();


    @Override
    public void add(Product product) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO PRODUCTS (ID, NAME, COST) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setLong(3, product.getCost());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();

        String sql = "SELECT ID, NAME, COST FROM PRODUCTS";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setCost(resultSet.getLong("COST"));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product getById(Long id) {
        PreparedStatement preparedStatement = null;

        Product product = new Product();

        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            product.setId(resultSet.getLong("ID"));
            product.setName(resultSet.getString("NAME"));
            product.setCost(resultSet.getLong("COST"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PRODUCTS SET NAME=? COST=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getCost());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Product product) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PRODUCTS WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, product.getId());

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
