/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama;

import java.util.Date;

/**
 *
 * @author m07er
 */
public class Product {
    
    //fields
    private long productID;
    private String productName;
    private long productCode;
    private String productDate;
    private Double productPrice;

    //constructor without parameter
    public Product() {

    }
    
    //constructor with parameters
    public Product(long productID, String productName, long productCode, String productDate,Double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productCode = productCode;
        this.productDate = productDate;
        this.productPrice = productPrice;
    }

    //Getter and Setter
    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductCode() {
        return productCode;
    }

    public void setProductCode(long productCode) {
        this.productCode = productCode;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    
}
