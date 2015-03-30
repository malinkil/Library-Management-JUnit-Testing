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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name = "BOOK_DETAILS")
public class BookDetails implements Serializable{
    
    public BookDetails(){}
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    
    @Column(name="TITLE", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    private String title;
    
    
    @Column(name="AUTHOR", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    private String author;
    
    
    @Column(name="PUBLICATION", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    private String publication;
    
    
    @Column(name="PRICE", nullable=false, columnDefinition = "INT", updatable=true)
    private int price;
    
    
    @Column(name="EDITION", nullable=false, columnDefinition = "VARCHAR(40)", updatable=true)
    private String edition;
    
    @OneToOne
    private StockDetails stockDetails;
    
    @OneToMany
    private List<BookClassification> bookClassification = new ArrayList<>();

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public StockDetails getStockDetails() {
        return stockDetails;
    }

    public void setStockDetails(StockDetails stockDetails) {
        this.stockDetails = stockDetails;
    }

    public List<BookClassification> getBookClassification() {
        return bookClassification;
    }

    public void setBookClassification(List<BookClassification> bookClassification) {
        this.bookClassification = bookClassification;
    }
    
    
}
