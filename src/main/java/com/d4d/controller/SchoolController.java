/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.School;
import com.d4d.service.SchoolService;
import com.d4d.util.ApiKey;
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
    @Autowired
    private ApiKey apiKey;
    
    @Autowired
    private SchoolService schoolService;

    @ResponseBody
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> create(@RequestHeader("apikey") String api_key, @RequestBody School school) {

        if (apiKey.checkApiKey(api_key)) {

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
    public ResponseEntity<School> getSchool(@RequestHeader("apikey") String api_key, @RequestParam String name) {
        if (apiKey.checkApiKey(api_key)) {
            try {

                School school = schoolService.getByName(name);
                return new ResponseEntity<>(school, HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<School>> getAll(@RequestHeader("apikey") String api_key) {

        if (apiKey.checkApiKey(api_key)) {
            try {
                List<School> schools = schoolService.getAll();
                return new ResponseEntity<>(schools, HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> update(@RequestHeader("apikey") String api_key, @RequestBody School school) {

        if (apiKey.checkApiKey(api_key)) {
            try {

                School p = schoolService.update(school);
                return new ResponseEntity<>(p.toString(), HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/delete")
    public ResponseEntity<String> delete(@RequestHeader("apikey") String api_key, @RequestParam String name) {

        if (apiKey.checkApiKey(api_key)) {
            try {

                schoolService.delete(name);
                return new ResponseEntity<>("Deleted " + name, HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(@RequestHeader("apikey") String api_key) {

        if (apiKey.checkApiKey(api_key)) {
            try {

                schoolService.deleteAll();
                return new ResponseEntity<>("All Schools Deleted", HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
