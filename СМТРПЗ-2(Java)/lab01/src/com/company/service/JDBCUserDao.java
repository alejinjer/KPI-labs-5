package com.company.service;

import com.company.Util;
import com.company.dao.UserDao;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDao extends Util implements UserDao {

    private String sqlCreateTable = "create table users (ID bigint NOT NULL, NAME character varying(255) NOT NULL, ADDRESS character varying(255) NOT NULL, CONSTRAINT ID PRIMARY KEY (ID));";
    private String sqlDeleteTable = "drop table users";

    private Connection connection = getMySQLConnection();

    @Override
    public void add(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO USERS (ID, NAME, ADDRESS) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getAddress());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT ID, NAME, ADDRESS FROM USERS";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setAddress(resultSet.getString("ADDRESS"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        User user = new User();

        String sql = "SELECT * FROM USERS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            user.setId(resultSet.getLong("ID"));
            user.setName(resultSet.getString("NAME"));
            user.setAddress(resultSet.getString("ADDRESS"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE USERS SET NAME=? ADDRESS=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setLong(3, user.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM USERS WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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
