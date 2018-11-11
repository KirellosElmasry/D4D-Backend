/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.service;

import com.d4d.model.Nursery;
import com.d4d.repository.NurseryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kirellos
 */
@Service
public class NurseryService {

    @Autowired
    private NurseryRepository nurseryRepository;

    //create operation 
    public Nursery create(Nursery nursery) {
        return nurseryRepository.save(nursery);
    }

    //Retrive operation
    public List<Nursery> getAll() {
        return nurseryRepository.findAll();
    }

    public Nursery getByName(String name) {
        return nurseryRepository.findByName(name);
    }

    public Nursery getById(String id) {
        return nurseryRepository.findById(id);
    }

    //update operation 
    public Nursery update(Nursery nursery) {
        return nurseryRepository.save(nursery);
    }

    //Delete operation
    public void deleteAll() {
        nurseryRepository.deleteAll();
    }

    public void delete(String firstName) {
        Nursery p = nurseryRepository.findByName(firstName);
        nurseryRepository.delete(p);
    }
}
