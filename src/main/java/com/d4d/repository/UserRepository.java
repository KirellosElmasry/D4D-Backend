/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.repository;

import com.d4d.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kirellos
 */
@Repository
public interface UserRepository extends MongoRepository<User, Object>{
   
    public User findById(String id);
    public User findByName(String name);
    public User findByUserName(String userName);
    public User findByApiKey(String apiKey);
    public List<User> findByAddress(String address);

}
