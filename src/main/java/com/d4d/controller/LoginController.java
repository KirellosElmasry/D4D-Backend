/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.LoginData;
import com.d4d.model.User;
import com.d4d.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kirellos
 */
@RestController
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginData loginData) {

        if(loginData.getUserName() != null && loginData.getPassword() != null){
            try {
                
                User user = userService.getByUserName(loginData.getUserName());
                
                if(user != null){
                    if(user.getPassword().equals(loginData.getPassword())){
                         return new ResponseEntity<>(user.getApiKey(), HttpStatus.OK); 
                    }else{
                        return new ResponseEntity<>("wrong password", HttpStatus.UNAUTHORIZED); 
                    }
                }else{
                  return new ResponseEntity<>("User not found.", HttpStatus.UNAUTHORIZED);   
                }

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("error when login", HttpStatus.EXPECTATION_FAILED);
            }
        }else{
            return new ResponseEntity<>("Missing userName or password", HttpStatus.BAD_REQUEST);
        }
    }

}
