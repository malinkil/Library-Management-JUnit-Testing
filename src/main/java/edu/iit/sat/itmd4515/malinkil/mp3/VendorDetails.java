/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name="VENDOR_DETAILS")
public class VendorDetails implements Serializable{
    private static final long serialVersionUID=1L;
    
    public VendorDetails(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    
    @Column(name="FIRST_NAME", nullable =false, columnDefinition= "VARCHAR(40)", updatable=true)
    private String firstName;
    
    
    @Column(name="LAST_NAME", nullable =false, columnDefinition= "VARCHAR(40)", updatable=true)
    private String lastName;
    
    
    @Column(name="CONTACT_NUMBER", nullable =false, columnDefinition= "VARCHAR(40)", updatable=true)
    private String contactNumber;
    
    
    @Column(name="MAIL_ID", nullable =false, columnDefinition= "VARCHAR(40)", updatable=true)
    private String emailId;
    
    @Embedded private Address address;
    
    @OneToMany
    List<BookPurchaseDetails> bookPurchaseDetails = new ArrayList<>();
    
    @ManyToMany
    private List<BookDetails> books = new ArrayList<>();

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<BookPurchaseDetails> getBookPurchaseDetails() {
        return bookPurchaseDetails;
    }

    public void setBookPurchaseDetails(List<BookPurchaseDetails> bookPurchaseDetails) {
        this.bookPurchaseDetails = bookPurchaseDetails;
    }

    public List<BookDetails> getBooks() {
        return books;
    }

    public void setBooks(List<BookDetails> books) {
        this.books = books;
    }
    
    
    
}
