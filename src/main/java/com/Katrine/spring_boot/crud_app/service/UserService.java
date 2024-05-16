package com.Katrine.spring_boot.crud_app.service;

import com.Katrine.spring_boot.crud_app.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void save(User user);

    User getUserById(int id);

    void update(int id, User updatedUser);

    void delete(int id);
}
