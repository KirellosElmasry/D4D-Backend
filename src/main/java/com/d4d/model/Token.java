/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Kirellos
 */
@Document
public class Token {
    
    private String id;
    private String apiKey;
    private String userId;

    public Token() {
    }

    public Token(String apiKey, String userId) {
        this.apiKey = apiKey;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Token{" + "id=" + id + ", apiKey=" + apiKey + ", userId=" + userId + '}';
    }
   
}
