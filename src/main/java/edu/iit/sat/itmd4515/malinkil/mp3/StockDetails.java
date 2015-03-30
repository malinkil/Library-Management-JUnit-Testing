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
@Table(name="STOCK_DETAILS")
public class StockDetails implements Serializable {
    
    public StockDetails(){}
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;
    
    @Column(name="BOOK_ID", nullable=false, columnDefinition="INT", updatable=true)
    private int bookId;
    
    @Column(name="TOTAL_AVAILABLE_COUNT", nullable=false, columnDefinition="INT", updatable=true)
    private int totalAvailableCount;
    
    @Column(name="TOTAL_NUMBER_OF_BOOKS", nullable=false, columnDefinition="INT", updatable=true)
    private int totalNoOfBooks;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getTotalAvailableCount() {
        return totalAvailableCount;
    }

    public void setTotalAvailableCount(int totalAvailableCount) {
        this.totalAvailableCount = totalAvailableCount;
    }

    public int getTotalNoOfBooks() {
        return totalNoOfBooks;
    }

    public void setTotalNoOfBooks(int totalNoOfBooks) {
        this.totalNoOfBooks = totalNoOfBooks;
    }
    
    
    
}
