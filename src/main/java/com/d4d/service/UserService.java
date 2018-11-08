/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.service;

import com.d4d.model.User;
import com.d4d.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kirellos
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //create operation 
    public User create(User user) {
        return userRepository.save(user);
    }

    //Retrive operation
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByName(String name) {
        return userRepository.findByName(name);
    }
    
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
    public User getByApiKey(String apiKey) {
        return userRepository.findByApiKey(apiKey);
    }

    public User getById(String id) {
        return userRepository.findById(id);
    }

    //update operation 
    public User update(User user) {
        /*
        User p = userRepository.findById(user.getId());
        p.setName(user);
        p.setArea(area);
        p.setAddress(address);
        p.setReview(review);
        p.setRate(rate);
         */
        return userRepository.save(user);
    }

    //Delete operation
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void delete(String firstName) {
        User p = userRepository.findByName(firstName);
        userRepository.delete(p);
    }
}
