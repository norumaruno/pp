package com.Katrine.spring_boot.crud_app.service;

import com.Katrine.spring_boot.crud_app.dao.UserDao;
import com.Katrine.spring_boot.crud_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        userDao.update(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
