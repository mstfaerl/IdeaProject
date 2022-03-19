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
public class CategoryProductMain {

    public static void main(String[] args) {

        Category category = new Category(1, "Beyaz Eşya");
        Product product = new Product(1, "Çamaşır Makinesi", 599.99);
        Product productA = new Product(2, "Bulaşık Makinesi", 799.99);
        List<Product> listProduct = new ArrayList<Product>();
        category.setListProduct(listProduct);
        product.setCategory(category);
        productA.setCategory(category);
        category.getListProduct().add(product);
        category.getListProduct().add(productA);

        System.out.println("Kategori ID : " + category.getCategoryId());
        System.out.println("Kategori Adı : " + category.getCategoryName());
        System.out.println("-----------------------------");
        System.out.println("Ürün ID : " + product.getProductId());
        System.out.println("Ürün Adı : " + product.getProductName());
        System.out.println("Ürün Fiyatı : " + product.getSalesPrice());

        System.out.println("-------------------");

        System.out.println("ID        Ürün         Fiyat    ID   Kategori ");

        for (Product product1 : category.getListProduct()) {
            System.out.print(product1.getProductId() + "   ");
            System.out.print(product1.getProductName() + "   ");
            System.out.print(product1.getSalesPrice() + "   ");
            System.out.print(product1.getCategory().getCategoryId() + "   ");
            System.out.println(product1.getCategory().getCategoryName());
        }

//        product.setProductId(1);
//        product.setProductName("Çamaşır Makinesi");
//        product.setSalesPrice(699.99);
//        product.getCategory().setCategoryId(1);
//        product.getCategory().setCategoryName("Beyaz Eşya");
//        listProduct.add(product);
//        product.getCategory().setListProduct(listProduct);
    }
}
