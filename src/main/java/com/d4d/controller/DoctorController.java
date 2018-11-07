/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.controller;

import com.d4d.model.Doctor;
import com.d4d.service.DoctorService;
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
    private String apiKey = "1234";

    @Autowired
    private DoctorService doctorService;

    @ResponseBody
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, consumes = "application/json")    
    public ResponseEntity<String> create(@RequestHeader("apikey") String api_key, @RequestBody Doctor doctor) {

        if (api_key.equals(apiKey)) {

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
    public Doctor getDoctor(@RequestParam String name) {
        return doctorService.getByName(name);
    }

    @RequestMapping("/getAll")
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST, consumes = "application/json")
    public String update(@RequestHeader("apikey") String api_key, @RequestBody Doctor doctor) {
        Doctor p = doctorService.update(doctor);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName
    ) {
        doctorService.delete(firstName);
        return "Deleted " + firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        doctorService.deleteAll();
        return "All Deleted";
    }
}
