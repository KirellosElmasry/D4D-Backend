/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.Nursery;
import com.d4d.service.NurseryService;
import com.d4d.controller.util.ApiKey;
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
@RequestMapping("/nursery")
public class NurseryController {

    //for Token based authentication
    @Autowired
    private ApiKey apiKey;
    
    @Autowired
    private NurseryService nurseryService;

    @ResponseBody
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> create(@RequestHeader("apikey") String api_key, @RequestBody Nursery nursery) {

        if (apiKey.checkApiKey(api_key)) {

            try {

                Nursery p = nurseryService.create(nursery);
                return new ResponseEntity<>("Nursery inserted successfully with id: " + p.getId(), HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("error when adding new Nursery", HttpStatus.EXPECTATION_FAILED);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/get")
    public ResponseEntity<Nursery> getNursery(@RequestHeader("apikey") String api_key, @RequestParam String name) {
        if (apiKey.checkApiKey(api_key)) {
            try {

                Nursery nursery = nurseryService.getByName(name);
                return new ResponseEntity<>(nursery, HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<Nursery>> getAll(@RequestHeader("apikey") String api_key) {

        if (apiKey.checkApiKey(api_key)) {
            try {
                List<Nursery> nurserys = nurseryService.getAll();
                return new ResponseEntity<>(nurserys, HttpStatus.OK);

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
    public ResponseEntity<String> update(@RequestHeader("apikey") String api_key, @RequestBody Nursery nursery) {

        if (apiKey.checkApiKey(api_key)) {
            try {

                Nursery p = nurseryService.update(nursery);
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

                nurseryService.delete(name);
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

                nurseryService.deleteAll();
                return new ResponseEntity<>("All Nurserys Deleted", HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
