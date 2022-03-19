/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama2;

/**
 *
 * @author m07er
 */
public class Books {

    //Fields
    private long bookId;
    private String bookName;
    private double salesPrices;
    private String createdDate;
    private Author author;

    //Constructor without parameter
    public Books() {
    }

    //Constructor with parameters
    public Books(long bookId, String bookName, double salesPrices, String createdDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.salesPrices = salesPrices;
        this.createdDate = createdDate;
    }

    //Getter and Setter
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getSalesPrices() {
        return salesPrices;
    }

    public void setSalesPrices(double salesPrices) {
        this.salesPrices = salesPrices;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
