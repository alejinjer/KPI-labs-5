package com.example.lab02.dao;

import com.example.lab02.entity.User;
import com.example.lab02.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (id, name, address) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAddress());
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User getById(Long id) {
        String sql = "SELECT * FROM users WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name=?, address=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getAddress(), user.getId());
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM users WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void createTable() {
        String sql = "CREATE TABLE users(ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), ADDRESS VARCHAR(255))";
        jdbcTemplate.execute(sql);
    }

    public void deleteTable() {
        String sql = "DROP TABLE users";
        jdbcTemplate.execute(sql);
    }
}
