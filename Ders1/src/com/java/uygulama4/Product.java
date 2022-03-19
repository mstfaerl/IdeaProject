/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama4;



/**
 *
 * @author m07er
 */
public class Product extends CategoryProduct {

    private long productId;
    private Double productPrice;
    private Category category;

    public Product() {

    }

    public Product(long productId, Double productPrice) {
        this.productId = productId;
        this.productPrice = productPrice;

    }

    public Product(long productId, Double productPrice, String name, String date) {
        super(name, date);
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
}
