package com.example.implementation.services;

import com.example.implementation.User;
import com.example.interfaces.dao.UserDAOInterface;
import com.example.interfaces.facade.model.UserInterface;

import java.util.List;

public class UserServiceImpl implements UserInterface {

    private UserDAOInterface userDAO;

    public UserServiceImpl(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public User getUserById(long userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDAO.deleteUser(userId);
    }
}
