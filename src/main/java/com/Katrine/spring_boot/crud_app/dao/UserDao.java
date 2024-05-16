package com.Katrine.spring_boot.crud_app.dao;

import com.Katrine.spring_boot.crud_app.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void save(User user);

    User getUserById(int id);

    void update(User updatedUser);

    void delete(int id);
}
