/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author kirellos
 */
@Document
public class Doctor {
    
    @Id
    private String id;
    private String name;    
    private String address;
    private String clinicTimes;
    private String mobile;
    private String phone;
    private String mapLocation;
    private String notes;
    private String rate;

    public Doctor(String name, String address, String clinicTimes, String mobile, String phone, String mapLocation, String notes, String rate) {
        this.name = name;
        this.address = address;
        this.clinicTimes = clinicTimes;
        this.mobile = mobile;
        this.phone = phone;
        this.mapLocation = mapLocation;
        this.notes = notes;
        this.rate = rate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClinicTimes() {
        return clinicTimes;
    }

    public void setClinicTimes(String clinicTimes) {
        this.clinicTimes = clinicTimes;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", address=" + address + ", clinicTimes=" + clinicTimes + ", mobile=" + mobile + ", phone=" + phone + ", mapLocation=" + mapLocation + ", notes=" + notes + ", rate=" + rate + '}';
    }
    
    
}
