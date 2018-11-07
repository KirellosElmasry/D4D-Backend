/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.School;
import com.d4d.service.SchoolService;
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
@RestController
@RequestMapping("/school")
public class SchoolController {

    //for Token based authentication
    private String apiKey = "1234";

    @Autowired
    private SchoolService schoolService;

    @ResponseBody
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, consumes = "application/json")    
    public ResponseEntity<String> create(@RequestHeader("apikey") String api_key, @RequestBody School school) {

        if (api_key.equals(apiKey)) {

            try {
                School p = schoolService.create(school);
                return new ResponseEntity<>("School inserted successfully with id: " + p.getId(), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("error when adding new School", HttpStatus.EXPECTATION_FAILED);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/get")
    public School getSchool(@RequestParam String name) {
        return schoolService.getByName(name);
    }

    @RequestMapping("/getAll")
    public List<School> getAll() {
        return schoolService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST, consumes = "application/json")
    public String update(@RequestHeader("apikey") String api_key, @RequestBody School school) {
        School p = schoolService.update(school);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName
    ) {
        schoolService.delete(firstName);
        return "Deleted " + firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        schoolService.deleteAll();
        return "All Deleted";
    }
}
