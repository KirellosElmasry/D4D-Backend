/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author kirellos
 */
@Document
public class School {

    @Id
    private String id;
    private String name;
    private String area;
    private String address;
    private String review;
    private String rate;

    public School(String name, String area, String address, String review, String rate) {
        this.name = name;
        this.area = area;
        this.address = address;
        this.review = review;
        this.rate = rate;
    }

    public School() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "School{" + "id=" + id + ", name=" + name + ", area=" + area + ", address=" + address + ", review=" + review + ", rate=" + rate + '}';
    }
    
}
