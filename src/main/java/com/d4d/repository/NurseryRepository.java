/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.repository;

import com.d4d.model.Nursery;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kirellos
 */
@Repository
public interface NurseryRepository extends MongoRepository<Nursery, Object>{
   
    public Nursery findById(String id);
    public Nursery findByName(String name);
    public List<Nursery> findByAddress(String address);
}