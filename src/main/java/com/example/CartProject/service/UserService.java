package com.example.CartProject.service;

import com.example.CartProject.Entity.User;

public interface UserService {

    public void saveNewUser(User param);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
