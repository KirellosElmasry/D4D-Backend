/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.School;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SchoolRepository;

/**
 *
 * @author kirellos
 */
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    //create operation 
    public School create(String name, String area, String address, String review, String rate) {
        return schoolRepository.save(new School(name, area, address, review, rate));
    }

    //Retrive operation
    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    public School getByName(String name) {
        return schoolRepository.findByName(name);
    }

    //update operation 
    public School update(String name, String area, String address, String review, String rate) {
        
        School p = schoolRepository.findByName(name);
        p.setName(name);
        p.setArea(area);
        p.setAddress(address);
        p.setReview(review);
        p.setRate(rate);
        
        return schoolRepository.save(p);
    }
    
    //Delete operation
    public void deleteAll(){
        schoolRepository.deleteAll();
    }
    
    public void delete(String firstName){
        School p = schoolRepository.findByName(firstName);
        schoolRepository.delete(p);
    }
}

