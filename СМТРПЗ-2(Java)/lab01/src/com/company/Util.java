package com.company;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lab1";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static final String MongoDB_URL = "mongodb+srv://Admin:admin@mongodb-w3mg4.mongodb.net/?retryWrites=true&w=majority";


    public Connection getMySQLConnection() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

    public MongoClient getMongoConnection() {
        MongoClient mongoClient = MongoClients.create(MongoDB_URL);
        return mongoClient;
    }
}
