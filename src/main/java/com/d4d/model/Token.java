/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.model;

/**
 *
 * @author Kirellos
 */
public class Token {
    
    private String id;
    private String apiKey;

    public Token() {
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

    @Override
    public String toString() {
        return "Token{" + "id=" + id + ", apiKey=" + apiKey + '}';
    }
    
    
}
