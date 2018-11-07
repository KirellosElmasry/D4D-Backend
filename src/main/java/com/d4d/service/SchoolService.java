/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.service;

import com.d4d.model.School;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d4d.repository.SchoolRepository;

/**
 *
 * @author kirellos
 */
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    //create operation 
    public School create(School school) {
        return schoolRepository.save(school);
    }

    //Retrive operation
    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    public School getByName(String name) {
        return schoolRepository.findByName(name);
    }
    public School getById(String id) {
        return schoolRepository.findById(id);
    }

    //update operation 
    public School update(School school) {
        /*
        School p = schoolRepository.findById(school.getId());
        p.setName(school);
        p.setArea(area);
        p.setAddress(address);
        p.setReview(review);
        p.setRate(rate);
        */
        return schoolRepository.save(school);
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

