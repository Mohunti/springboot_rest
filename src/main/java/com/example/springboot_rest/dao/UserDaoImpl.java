package com.example.springboot_rest.dao;

import com.example.springboot_rest.models.User;
import com.example.springboot_rest.service.UserServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class  UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
       // User user = entityManager.find(User.class, id);
       // entityManager.remove(user);

        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :developerId");
        query.setParameter("developerId", id);
        query.executeUpdate();
    }

    @Override
    public User getUserName(String name) {
        Query query = entityManager.createQuery("from User u join fetch u.roles where u.username =: name ");
        query.setParameter("name", name);
        return (User)query.getSingleResult();
    }
}
