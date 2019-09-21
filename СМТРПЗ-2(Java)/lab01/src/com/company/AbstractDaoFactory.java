package com.company;

import com.company.dao.OrderDao;
import com.company.dao.ProductDao;
import com.company.dao.UserDao;

public interface AbstractDaoFactory {
    UserDao createUserDao();

    ProductDao createProductDao();

    OrderDao createOrderDao();
}
