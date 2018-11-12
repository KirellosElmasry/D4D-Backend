/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.Doctor;
import com.d4d.service.DoctorService;
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
@RequestMapping("/doctor")
public class DoctorController {
    
//for Token based authentication
    @Autowired
    private ApiKey apiKey;
    
    @Autowired
    private DoctorService doctorService;

    @ResponseBody
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> create(@RequestHeader("apikey") String api_key, @RequestBody Doctor doctor) {

        if (apiKey.checkApiKey(api_key)) {

            try {

                Doctor p = doctorService.create(doctor);
                return new ResponseEntity<>("Doctor inserted successfully with id: " + p.getId(), HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("error when adding new Doctor", HttpStatus.EXPECTATION_FAILED);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/get")
    public ResponseEntity<Doctor> getDoctor(@RequestHeader("apikey") String api_key, @RequestParam String name) {
        if (apiKey.checkApiKey(api_key)) {
            try {

                Doctor doctor = doctorService.getByName(name);
                return new ResponseEntity<>(doctor, HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<Doctor>> getAll(@RequestHeader("apikey") String api_key) {

        if (apiKey.checkApiKey(api_key)) {
            try {
                List<Doctor> doctors = doctorService.getAll();
                return new ResponseEntity<>(doctors, HttpStatus.OK);

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
    public ResponseEntity<String> update(@RequestHeader("apikey") String api_key, @RequestBody Doctor doctor) {

        if (apiKey.checkApiKey(api_key)) {
            try {

                Doctor p = doctorService.update(doctor);
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

                doctorService.delete(name);
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

                doctorService.deleteAll();
                return new ResponseEntity<>("All Doctors Deleted", HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}