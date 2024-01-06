package com.jobportal.server.service;

import com.jobportal.server.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    User authenticate(String email, String password);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
