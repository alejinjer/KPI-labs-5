package com.company.service;

import com.company.Util;
import com.company.dao.UserDao;
import com.company.entity.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBUserDao extends Util implements UserDao {

    private MongoClient mongoClient = getMongoConnection();
    private MongoDatabase database = mongoClient.getDatabase("lab1");
    private MongoCollection<Document> collection = database.getCollection("users");

    @Override
    public void add(User user) throws SQLException {
        Document document = new Document();
        document.append("ID", user.getId());
        document.append("NAME", user.getName());
        document.append("ADDRESS", user.getAddress());
        collection.insertOne(document);
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<User>();

        for (Document document : collection.find()) {
            User user = new User();
            user.setId((long) document.get("ID"));
            user.setName(document.get("NAME").toString());
            user.setAddress(document.get("ADDRESS").toString());

            userList.add(user);
        }

        return userList;
    }

    @Override
    public User getById(Long id) throws SQLException {
        User user = new User();

        Document searchResult = collection.find(new Document("ID", id)).first();
        if (searchResult != null) {
            user.setId(id);
            user.setName(searchResult.get("NAME").toString());
            user.setAddress(searchResult.get("ADDRESS").toString());
            return user;
        }

        return null;
    }

    @Override
    public void update(User user) throws SQLException {
        Document oldUser = collection.find(new Document("ID", user.getId())).first();

        Bson updatedValue = new Document("NAME", user.getName());
        ((Document) updatedValue).append("ADDRESS", user.getAddress());
        Bson updateOperation = new Document("$set", updatedValue);

        collection.updateOne(oldUser, updateOperation);
    }

    @Override
    public void remove(User user) throws SQLException {
        Document delUser = collection.find(new Document("ID", user.getId())).first();
        collection.deleteOne(delUser);
    }

    @Override
    public void createTable() {

    }

    @Override
    public void deleteTable() {
        collection.deleteMany(new Document());
    }
}
