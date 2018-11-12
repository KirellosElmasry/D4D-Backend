/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d4d.model.request;

/**
 *
 * @author Kirellos
 */
public class MapLocation {
    
    private long latitude;  
    private long longitude;

    public MapLocation() {
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "MapLocation{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
    }
    
}
