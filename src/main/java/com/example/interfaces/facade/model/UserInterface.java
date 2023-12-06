package com.example.interfaces.facade.model;

import com.example.implementation.User;

import java.util.List;

public interface UserInterface {

    User createUser(User user);

    User getUserById(long userId);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(long userId);
}
