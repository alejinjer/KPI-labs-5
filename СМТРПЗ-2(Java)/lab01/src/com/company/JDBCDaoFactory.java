package com.company;

import com.company.dao.OrderDao;
import com.company.dao.ProductDao;
import com.company.dao.UserDao;
import com.company.service.JDBCOrderDao;
import com.company.service.JDBCProductDao;
import com.company.service.JDBCUserDao;

public class JDBCDaoFactory implements AbstractDaoFactory{
    private static JDBCDaoFactory ourInstance = new JDBCDaoFactory();

    public static JDBCDaoFactory getInstance() {
        return ourInstance;
    }

    private JDBCDaoFactory() {
    }

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new JDBCProductDao();
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao();
    }
}
