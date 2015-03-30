/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mithun.alinkil
 */

@Embeddable
public class Address implements Serializable  {
    
    public Address(){}
    @Column(name="STREET_NAME", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    String street;
    
    @Column(name="CITY_NAME", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    String city;

    @Column(name="STATE_NAME", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    String state;
    
    @Column(name="COUNTRY_NAME", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    String country;
    
    @Column(name="ZIP_CODE", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    long zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }
    
    
    
    
    
    
}
