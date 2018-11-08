/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.User;
import com.d4d.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kirellos
 */
@RequestMapping("/user")
@RestController
public class UserController {
    
    //for Token based authentication
    private String apiKey = "1234";

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, consumes = "application/json")    
    public ResponseEntity<String> create(@RequestHeader("apikey") String api_key, @RequestBody User user) {

        if (api_key.equals(apiKey)) {

            try {
                User p = userService.create(user);
                return new ResponseEntity<>("User inserted successfully with id: " + p.getId(), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("error when adding new User", HttpStatus.EXPECTATION_FAILED);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/get")
    public User getUser(@RequestParam String name) {
        return userService.getByName(name);
    }

    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST, consumes = "application/json")
    public String update(@RequestHeader("apikey") String api_key, @RequestBody User user) {
        User p = userService.update(user);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String name) {
        userService.delete(name);
        return "Deleted " + name;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        userService.deleteAll();
        return "All Deleted";
    }
}

