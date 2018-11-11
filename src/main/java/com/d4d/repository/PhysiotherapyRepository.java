/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.repository;

import com.d4d.model.Nursery;
import com.d4d.model.Physiotherapy;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kirellos
 */
@Repository
public interface PhysiotherapyRepository extends MongoRepository<Physiotherapy, Object>{
   
    public Physiotherapy findById(String id);
    public Physiotherapy findByName(String name);
    public List<Physiotherapy> findByAddress(String address);
}