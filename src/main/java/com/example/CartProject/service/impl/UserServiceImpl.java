package com.example.CartProject.service.impl;


import com.example.CartProject.Entity.User;
import com.example.CartProject.Repository.UserRepository;
import com.example.CartProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public void saveNewUser(User param){
        param.setCreatedBy("User");
        param.setIsDeleted(0);
        Date today = Date.from(Instant.now());
        param.setCreatedDate(String.valueOf(today));
        userRepository.save(param);
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(Long id, User param){
        User user = userRepository.findById(id).get();
        param.setIsDeleted(0);
        param.setName(param.getName());
        param.setEmail(param.getEmail());
        param.setPassword(param.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }

}
