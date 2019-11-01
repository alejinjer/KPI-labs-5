package com.company;

import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.User;
import com.company.service.JDBCOrderDao;
import com.company.service.JDBCProductDao;
import com.company.service.JDBCUserDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JDBCFacade jdbcFacade = new JDBCFacade();

        jdbcFacade.createDb();

        JDBCUserDao jdbcUserDao = (JDBCUserDao) JDBCDaoFactory.getInstance().createUserDao();
        JDBCProductDao jdbcProductDao = (JDBCProductDao) JDBCDaoFactory.getInstance().createProductDao();
        JDBCOrderDao jdbcOrderDao = (JDBCOrderDao) JDBCDaoFactory.getInstance().createOrderDao();

        User user1 = new User((long)123, "Sasha", "TROYA");
        User user2 = new User((long)456, "Kolya", "PZNK");
        User user3 = new User((long)789, "Vasiliy", "Boyarka");
        User user4 = new User((long)012, "Maks", "SOLOMA");

        Product product1 = new Product((long)24565, "ogure4ik", (long)12);
        Product product2 = new Product((long)72456, "pomidor", (long)12);
        Product product3 = new Product((long)56377, "voormooshel`ka", (long)12);
        Product product4 = new Product((long)83568, "bulba", (long)12);

        Order order1 = new Order((long)1, user1.getId(), product1.getId());
        Order order2 = new Order((long)2, user1.getId(), product3.getId());
        Order order3 = new Order((long)3, user1.getId(), product4.getId());
        Order order4 = new Order((long)4, user2.getId(), product2.getId());
        Order order5 = new Order((long)5, user2.getId(), product3.getId());
        Order order6 = new Order((long)6, user3.getId(), product4.getId());
        Order order7 = new Order((long)7, user4.getId(), product2.getId());
        Order order8 = new Order((long)8, user4.getId(), product1.getId());

        jdbcUserDao.add(user1);
        jdbcUserDao.add(user2);
        jdbcUserDao.add(user3);
        jdbcUserDao.add(user4);

        jdbcProductDao.add(product1);
        jdbcProductDao.add(product2);
        jdbcProductDao.add(product3);
        jdbcProductDao.add(product4);

        jdbcOrderDao.add(order1);
        jdbcOrderDao.add(order2);
        jdbcOrderDao.add(order3);
        jdbcOrderDao.add(order4);
        jdbcOrderDao.add(order5);
        jdbcOrderDao.add(order6);
        jdbcOrderDao.add(order7);
        jdbcOrderDao.add(order8);

        jdbcFacade.showDb();
//        jdbcFacade.deleteDb();

    }
}
