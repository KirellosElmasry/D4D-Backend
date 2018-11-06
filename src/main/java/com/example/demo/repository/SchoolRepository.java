/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.School;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kirellos
 */
@Repository
public interface SchoolRepository extends MongoRepository<School, Object>{
   
    public School findByName(String name);
    public List<School> findByAge(int age);
}
