package com.example.springboot_rest.service;



import com.example.springboot_rest.models.User;

import java.util.List;

public interface UserService  {
    List<User> getAllUsers();

    User getUserName(String name);

    Object showUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    void save(User user);
}