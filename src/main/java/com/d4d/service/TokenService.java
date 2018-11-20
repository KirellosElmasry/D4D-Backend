/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.service;

import com.d4d.model.Token;
import com.d4d.repository.TokenRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kirellos
 */
@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    //generate operation 
    public String generate() {
        
        int length = 60;
        
        String randomStr = UUID.randomUUID().toString();
        
        while (randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        
        return randomStr.substring(0, length);
    }

    //create operation 
    public Token create(Token token) {
        return tokenRepository.save(token);
    }

    //Retrive operation
    public List<Token> getAll() {
        return tokenRepository.findAll();
    }

    public Token getByApiKey(String apiKey) {
        return tokenRepository.findByApiKey(apiKey);
    }

    public Token getById(String id) {
        return tokenRepository.findById(id);
    }

    //update operation 
    public Token update(Token token) {
        return tokenRepository.save(token);
    }

    //Delete operation
    public void deleteAll() {
        tokenRepository.deleteAll();
    }

    public void delete(String apiKey) {
        Token p = tokenRepository.findByApiKey(apiKey);
        tokenRepository.delete(p);
    }
}
