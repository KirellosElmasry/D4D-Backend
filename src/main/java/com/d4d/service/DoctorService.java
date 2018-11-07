/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.service;

import com.d4d.model.Doctor;
import com.d4d.repository.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kirellos
 */
@Service
public class DoctorService {
   
    @Autowired
    private DoctorRepository doctorRepository;

    //create operation 
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    //Retrive operation
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getByName(String name) {
        return doctorRepository.findByName(name);
    }
    public Doctor getById(String id) {
        return doctorRepository.findById(id);
    }

    //update operation 
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    //Delete operation
    public void deleteAll(){
        doctorRepository.deleteAll();
    }
    
    public void delete(String firstName){
        Doctor p = doctorRepository.findByName(firstName);
        doctorRepository.delete(p);
    } 
}
