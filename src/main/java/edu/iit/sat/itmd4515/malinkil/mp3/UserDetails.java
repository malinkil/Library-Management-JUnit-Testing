/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name="USER_DETAILS")
public class UserDetails implements Serializable {
    
    public UserDetails(){}
    
    private static final long serialVersionUID= 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="FIRST_NAME", nullable=false, columnDefinition="VARCHAR(40)", updatable=true)
    private String firstName;
    
    @Column(name="LAST_NAME", nullable=false, columnDefinition="VARCHAR(40)", updatable=true)
    private String lastName;
    
    @Embedded
    private Address address;
    
    @Column(name="CONTACT_NUMBER", nullable=false, columnDefinition="VARCHAR(40)", updatable=true)
    private String contactNumber;
    
    @Column(name="MAIL_ID", nullable=false, columnDefinition="VARCHAR(40)", updatable=true)
    private String mailId;
    
    @OneToOne
    private MembershipDetails memebershipDetail;
    
   @Column(name="DATE_OF_BIRTH", nullable=false, updatable=true)
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateofBirth;
   
   @Column(name="DATE_OF_JOINING", nullable=false, updatable=true)
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateofJoining;
   
   @Column(name="RENEWAL_DATE", nullable=false, updatable=true)
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date renewalDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public MembershipDetails getMemebershipDetail() {
        return memebershipDetail;
    }

    public void setMemebershipDetail(MembershipDetails memebershipDetail) {
        this.memebershipDetail = memebershipDetail;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public Date getDateofJoining() {
        return dateofJoining;
    }

    public void setDateofJoining(Date dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }
   
   
    
    
}
