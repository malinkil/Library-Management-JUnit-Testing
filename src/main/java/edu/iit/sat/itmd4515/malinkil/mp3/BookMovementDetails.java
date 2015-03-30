/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name="BOOK_MOVEMENT_DETAILS")
public class BookMovementDetails implements Serializable{
    
    public BookMovementDetails (){}
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "BOOK_ID", nullable = false, columnDefinition="INT", updatable=true)
    private int BookId;
    
    @Column(name = "USER_ID", nullable = false, columnDefinition="INT", updatable=true)
    private int userId;
    
    @Column(name = "TAKEN_DATE", nullable = false, updatable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookTakenDate;
    
    @Column(name = "RETURNING_DATE", nullable = false, updatable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookReturnDate;
    
    @Column(name = "OVERDUE_DAYS", nullable = false, columnDefinition="INT", updatable=true)
    private int overDueDays;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBookTakenDate() {
        return bookTakenDate;
    }

    public void setBookTakenDate(Date bookTakenDate) {
        this.bookTakenDate = bookTakenDate;
    }

    public Date getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(Date bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public int getOverDueDays() {
        return overDueDays;
    }

    public void setOverDueDays(int overDueDays) {
        this.overDueDays = overDueDays;
    }
    
    
    
    
    
    
}
