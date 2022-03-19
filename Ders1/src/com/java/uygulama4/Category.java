/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama4;

import java.util.List;

/**
 *
 * @author m07er
 */
public class Category extends CategoryProduct {

    private long categoryId;
    private List<Product> listProduct;

    public Category() {

    }

    public Category(long categoryId) {
        this.categoryId = categoryId;
    }

    public Category(long categoryId, String name, String date) {
        super(name, date);
        this.categoryId = categoryId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

}
