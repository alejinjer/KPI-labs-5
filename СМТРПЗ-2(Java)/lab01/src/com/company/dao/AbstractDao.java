package com.company.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T> {

    void createTable();

    void deleteTable();

    //create
    void add(T t) throws SQLException;

    //read
    List<T> getAll() throws SQLException;
    T getById(Long id) throws SQLException;

    //update
    void update(T order) throws SQLException;

    //delete
    void remove(T order) throws SQLException;

}
