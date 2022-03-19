/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m07er
 */
public class Category {

    //Fields
    private long categoryId;
    private String categoryName;
    private List<Product> listProduct;

    //Constructor
    public Category() {

    }

    //Constructor with parameters
    public Category(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    //Getter and Setter
    public List<Product> getListProduct() {
//        if(this.listProduct == null){
//            this.listProduct = new ArrayList<>();
//        }
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
