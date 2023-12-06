package com.example.implementation.dao;

import com.example.implementation.User;
import com.example.interfaces.dao.UserDAOInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDAO implements UserDAOInterface {

    private final Map<Long, User> userMap = new HashMap<>();
    private long currentId = 1;

    @Override
    public User createUser(User user) {
        user.setId(currentId);
        userMap.put(currentId, user);
        currentId++;
        return user;
    }

    @Override
    public User getUserById(long userId) {
        return userMap.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userMap.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
        } else {
            throw new IllegalArgumentException("User not found, try again");
        }
    }

    @Override
    public void deleteUser(long userId) {
        userMap.remove(userId);
    }
}
