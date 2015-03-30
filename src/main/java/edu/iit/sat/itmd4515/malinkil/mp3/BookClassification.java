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
@Table(name="BOOK_CLASSIFICATION")
public class BookClassification implements Serializable{
    
    public BookClassification(){}
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookClassificationId;
    
    @Column(name="BOOK_CATEGORY", nullable=false, columnDefinition="VARCHAR(40)", updatable=true)
    private String bookCategory;

    public int getBookClassificationId() {
        return bookClassificationId;
    }

    public void setBookClassificationId(int bookClassificationId) {
        this.bookClassificationId = bookClassificationId;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    
    @Column(name="BOOK_TYPE", nullable=false, columnDefinition="VARCHAR(40)", updatable=true)
    private String bookType;
    
    
    
    
    
}
