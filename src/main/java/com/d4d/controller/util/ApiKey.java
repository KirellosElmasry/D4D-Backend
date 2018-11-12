/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller.util;

import com.d4d.model.User;
import com.d4d.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kirellos
 */
@Service
public class ApiKey {
    
    @Autowired
    private UserService userService;
    
    public boolean checkApiKey(String apiKey){
        User user = userService.getByApiKey(apiKey);
        return null != user;
    }
}
