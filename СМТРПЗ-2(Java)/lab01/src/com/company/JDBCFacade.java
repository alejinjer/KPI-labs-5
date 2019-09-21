package com.company;

import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.User;
import com.company.service.JDBCOrderDao;
import com.company.service.JDBCProductDao;
import com.company.service.JDBCUserDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCFacade {


    private JDBCUserDao jdbcUserDao = null;
    private JDBCProductDao jdbcProductDao = null;
    private JDBCOrderDao jdbcOrderDao = null;

    public JDBCFacade() {
        this.jdbcUserDao = (JDBCUserDao) JDBCDaoFactory.getInstance().createUserDao();
        this.jdbcProductDao = (JDBCProductDao) JDBCDaoFactory.getInstance().createProductDao();
        this.jdbcOrderDao = (JDBCOrderDao) JDBCDaoFactory.getInstance().createOrderDao();
    }

    public void deleteDb() {
        jdbcUserDao.deleteTable();
        jdbcProductDao.deleteTable();
        jdbcOrderDao.deleteTable();
    }

    public void createDb() {
        jdbcUserDao.createTable();
        jdbcProductDao.createTable();
        jdbcOrderDao.createTable();
    }

    public void showDb() throws SQLException {
        ArrayList users = (ArrayList) jdbcUserDao.getAll();
        ArrayList products = (ArrayList) jdbcProductDao.getAll();
        ArrayList orders = (ArrayList) jdbcOrderDao.getAll();

        for (Object o : users) {
            System.out.println((User)o);
        }

        for (Object o : products) {
            System.out.println((Product)o);
        }

        for (Object o : orders) {
            System.out.println((Order)o);
        }
    }
}
