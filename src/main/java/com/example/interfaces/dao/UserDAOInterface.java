package com.example.interfaces.dao;

import com.example.implementation.User;

import java.util.List;

public interface UserDAOInterface {

    User createUser(User user);
    User getUserById(long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(long userId);
}
