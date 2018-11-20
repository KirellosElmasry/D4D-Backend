/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.repository;

import com.d4d.model.Token;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kirellos
 */
@Repository
public interface TokenRepository extends MongoRepository<Token, Object>{
    public Token findById(String id);
    public Token findByApiKey(String name);
    public List<Token> findByUserId(String address);
}
