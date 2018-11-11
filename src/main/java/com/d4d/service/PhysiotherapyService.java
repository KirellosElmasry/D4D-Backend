/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.service;

import com.d4d.model.Physiotherapy;
import com.d4d.repository.PhysiotherapyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kirellos
 */
@Service
public class PhysiotherapyService {
 @Autowired
    private PhysiotherapyRepository physiotherapyRepository;

    //create operation 
    public Physiotherapy create(Physiotherapy physiotherapy) {
        return physiotherapyRepository.save(physiotherapy);
    }

    //Retrive operation
    public List<Physiotherapy> getAll() {
        return physiotherapyRepository.findAll();
    }

    public Physiotherapy getByName(String name) {
        return physiotherapyRepository.findByName(name);
    }

    public Physiotherapy getById(String id) {
        return physiotherapyRepository.findById(id);
    }

    //update operation 
    public Physiotherapy update(Physiotherapy physiotherapy) {
        return physiotherapyRepository.save(physiotherapy);
    }

    //Delete operation
    public void deleteAll() {
        physiotherapyRepository.deleteAll();
    }

    public void delete(String firstName) {
        Physiotherapy p = physiotherapyRepository.findByName(firstName);
        physiotherapyRepository.delete(p);
    }
}
