/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class ProductMain {

    public static void main(String[] args) {

//        
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date1 = new Date(119, 11, 32);
//        String str1 = simpleDateFormat.format(date1);

        /*
        Product pro1 = new Product(1, "Televizyon", 123, "13-07-1997", 999.99);
        Product pro2 = new Product(2, "Bilgisayar", 124, "13-07-1997", 3999.99);
        Product pro3 = new Product(3, "Telefon", 125, "13-07-1997", 2999.99);
        Product pro4 = new Product(4, "Şarj Aleti", 126, "13-07-1997", 99.99);
        Product pro5 = new Product(5, "Projeksiyon", 127, "13-07-1997", 199.99);

        List<Product> productList = new ArrayList<>();

        productList.add(pro1);
        productList.add(pro2);
        productList.add(pro3);
        productList.add(pro4);
        productList.add(pro5);

        System.out.println("ProductList with ArrayList\n");
        for (Product product : productList) {
            System.out.println("Product ID : " + product.getProductID() + "\nProduct Name : " + product.getProductName() + "\nProduct Code : " + product.getProductCode() + "\nProduct Date : " + product.getProductDate() + "\nProduct Price : " + product.getProductPrice() + "\n");
        }

        System.out.println("-------------------------------------------------");

        System.out.println("ProductList with LinkedList\n");
        List<Product> productLinkedList = new LinkedList<>();

        productLinkedList.add(pro1);
        productLinkedList.add(pro2);
        productLinkedList.add(pro3);
        productLinkedList.add(pro4);
        productLinkedList.add(pro5);

        for (Product product : productLinkedList) {
            System.out.println("Product ID : " + product.getProductID() + "\nProduct Name : " + product.getProductName() + "\nProduct Code : " + product.getProductCode() + "\nProduct Date : " + product.getProductDate() + "\nProduct Price : " + product.getProductPrice() + "\n");
        }
         */
        Scanner scan = new Scanner(System.in);
        List<Product> productLinkedList = new LinkedList<>();
        while (true) {
            System.out.print("Lütfen ürün id ekleyiniz : ");
            Long productID = scan.nextLong();
            System.out.print("Lütfen ürün ismi ekleyiniz : ");
            String productName = scan.next();
            System.out.print("Lütfen ürün ürün kodu ekleyiniz : ");
            Long productCode = scan.nextLong();
            System.out.print("Lütfen ürün tarihi ekleyiniz : ");
            String productDate = scan.next();
            System.out.print("Lütfen ürün fiyatı ekleyiniz : ");
            Double productPrice = scan.nextDouble();

            Product pro = new Product(productID, productName, productCode, productDate, productPrice);
            productLinkedList.add(pro);

            System.out.println("");
            for (Product product : productLinkedList) {
                System.out.println("Product ID : " + product.getProductID() + "\nProduct Name : " + product.getProductName() + "\nProduct Code : " + product.getProductCode() + "\nProduct Date : " + product.getProductDate() + "\nProduct Price : " + product.getProductPrice() + "\n");
            }
            System.out.println("Eklendi.\n");
        }
    }

}
