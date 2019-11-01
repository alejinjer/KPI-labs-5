package com.example.lab02.service;

import com.example.lab02.dao.UserDao;
import com.example.lab02.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(Long id) {
        userDao.remove(id);
    }
}
