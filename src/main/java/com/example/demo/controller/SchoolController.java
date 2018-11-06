/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kirellos
 */
@RestController
public class SchoolController {
    
    @Autowired
    private SchoolService schoolService;
    
    @RequestMapping("/create")
    public String create(@RequestParam String name, @RequestParam String area, @RequestParam String address, @RequestParam String review, @RequestParam String rate) {
        School p = schoolService.create(name, area, address, review, rate);
        return p.toString();
    }
    
    @RequestMapping("/get")
    public School getPerson(@RequestParam String name){
        return schoolService.getByName(name);
    }
    
    @RequestMapping("/getAll")
    public List<School> getAll(){
        return schoolService.getAll();
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam String name, @RequestParam String area, @RequestParam String address, @RequestParam String review, @RequestParam String rate) {
        School p = schoolService.update(name, area, address, review, rate);
        return p.toString();        
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName){
        schoolService.delete(firstName);
        return "Deleted "+firstName;
    }
    
    @RequestMapping("/deleteAll")
    public String deleteAll(){
        schoolService.deleteAll();
        return "All Deleted";
    }
}
