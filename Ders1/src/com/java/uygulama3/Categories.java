/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama3;

/**
 *
 * @author m07er
 */
public class Categories {
    
    private long categoryID;
    private String categoryName;
    private double categoryPrice;

    public Categories() {
    }

    public Categories(long categoryID, String categoryName, double categoryPrice) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryPrice = categoryPrice;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(double categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    
    
}
