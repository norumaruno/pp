package com.Katrine.spring_boot.crud_app.dao;

import com.Katrine.spring_boot.crud_app.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(int id) {
        entityManager.remove(getUserById(id));
    }
}
