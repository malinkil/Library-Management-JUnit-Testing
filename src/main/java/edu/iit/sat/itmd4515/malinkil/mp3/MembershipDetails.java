/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name="MEMBERSHIP_DETAILS")
public class MembershipDetails implements Serializable {
    
    public MembershipDetails(){}
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int membershipTypeId;
    
    @Column(name ="MEMBER_TYPE", nullable=false, columnDefinition="VARCHAR(40)", updatable= true)
    private String memberType;
    
    @Column(name ="DURATION", nullable=false, columnDefinition="VARCHAR(40)", updatable= true)
    private String duration;
    
    
    @Column(name ="COST", nullable=false, columnDefinition="VARCHAR(40)", updatable= true)
    private int cost;

    public int getMembershipTypeId() {
        return membershipTypeId;
    }

    public void setMembershipTypeId(int membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    
    
    
}
