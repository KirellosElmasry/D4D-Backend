/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.repository;

import com.d4d.model.Doctor;
import com.d4d.model.School;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kirellos
 */
@Repository
public interface DoctorRepository extends MongoRepository<Doctor, Object>{
    
    public Doctor findById(String id);
    public Doctor findByName(String name);
    public List<Doctor> findByAddress(String address);
}
