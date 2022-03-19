/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class CategoryProductMain {

    public static void main(String[] args) {

        List<Category> categoryList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        String categoryPath = "D:\\Data\\Category.txt";
        String productPath = "D:\\Data\\Product.txt";

        long productId = 0;
        long categoryId = 0;

        while (true) {

            System.out.println("Merhabalar, Hoşgeldiniz!");
            System.out.println("1-Product");
            System.out.println("2-Category");
            System.out.print("Lütfen ekleme yapmak istediğiniz grubu seçiniz : ");
            int grup = scan().nextInt();
            if (grup == 1) {
                productId++;
            } else if (grup == 2) {
                categoryId++;
            }
            switch (grup) {

                case 1:
                    System.out.println("1-Ekleme");
                    System.out.println("2-Güncelleme");
                    System.out.println("3-Silme");
                    System.out.println("4-Listeleme");
                    System.out.print("Lütfen hangi işlemi yapmak istediğinizi bildiriniz : ");
                    int girdi = scan().nextInt();
                    switch (girdi) {
                        case 1:
                            System.out.print("Lütfen ürün ismi giriniz : ");
                            String productName = scan().nextLine();
                            System.out.print("Lütfen fiyat giriniz :  ");
                            Double produtPrice = scan().nextDouble();
                            System.out.print("Lütfen yıl/ay/gün (aralarında boşluk olacak şekilde) formatında tarih giriniz : ");
                            String date = scan().nextLine();
                            String[] arr = date.split(" ");
                            int year = Integer.parseInt(arr[0]);
                            int month = Integer.parseInt(arr[1]);
                            int day = Integer.parseInt(arr[2]);
                            String productDate = date(year, month, day);
                            Product product = new Product(productId, produtPrice, productName, productDate);
                            String str = "";
                            try (BufferedReader bR = new BufferedReader(new FileReader(categoryPath))) {
                                String str1 = "";
                                while ((str1 = bR.readLine()) != null) {
                                    str += str1;
                                }
                                String[] arr1 = str.split(" ");

                                int limit = arr1.length / 3;

                                Long[] cId = new Long[limit];
                                int j = 0;
                                for (int i = 0; i < arr1.length; i += 3) {
                                    cId[j] = Long.parseLong(arr1[i]);
                                    j++;
                                }

                                String[] cName = new String[limit];
                                int k = 0;
                                for (int i = 1; i < arr1.length; i += 3) {
                                    cName[k] = arr1[i];
                                    k++;
                                }

                                String[] cDate = new String[limit];
                                int l = 0;
                                for (int i = 2; i < arr1.length; i += 3) {
                                    cDate[l] = arr1[i];
                                    l++;
                                }

                                categoryList = new ArrayList<>();
                                Category category = null;
                                for (int i = 0; i < limit; i++) {
                                    category = new Category(cId[i], cName[i], cDate[i]);
                                    categoryList.add(category);
                                }

                                for (Category cat : categoryList) {
                                    System.out.println(cat.getCategoryId() + " " + cat.getName() + " " + cat.getDate());
                                }

                                System.out.print("Lütfen ekleyeceğiniz kategorinin id'siniz giriniz : ");
                                long id = scan().nextLong();

                                Category cat = null;
                                for (int i = 0; i < categoryList.size(); i++) {
                                    if (categoryList.get(i).getCategoryId() == id) {
                                        cat = new Category();
                                        cat.setCategoryId(categoryList.get(i).getCategoryId());
                                        cat.setName(categoryList.get(i).getName());
                                        cat.setDate(categoryList.get(i).getDate());
                                    }
                                }

                                cat.setListProduct(productList);
                                product.setCategory(cat);
                                cat.getListProduct().add(product);

                                try (BufferedWriter bW = new BufferedWriter(new FileWriter(productPath))) {
                                    for (Product pro : productList) {
                                        bW.write(pro.getProductId() + " " + pro.getName() + " " + pro.getDate() + " " + pro.getCategory().getCategoryId() + " " + pro.getCategory().getName() + " " + pro.getDate() + " ");
                                    }
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            for (Product pro : productList) {
                                System.out.println(pro.getProductId() + " " + pro.getName() + " " + pro.getDate() + " " + pro.getCategory().getCategoryId() + " " + pro.getCategory().getName() + " " + pro.getDate());
                            }
                            break;
                        default:
                            break;
                    }

                    break;
                case 2:
                    System.out.println("1-Ekleme");
                    System.out.println("2-Güncelleme");
                    System.out.println("3-Silme");
                    System.out.println("4-Listeleme");
                    System.out.print("Lütfen hangi işlemi yapmak istediğinizi bildiriniz : ");
                    int girdi1 = scan().nextInt();
                    switch (girdi1) {
                        case 1:
                            System.out.print("Lütfen kategori ismini giriniz : ");
                            String categoryName = scan().nextLine();
                            System.out.print("Lütfen yıl/ay/gün (aralarında boşluk olacak şekilde) formatında tarih giriniz : ");
                            String date = scan().nextLine();
                            String[] arr = date.split(" ");
                            int year = Integer.parseInt(arr[0]);
                            int month = Integer.parseInt(arr[1]);
                            int day = Integer.parseInt(arr[2]);
                            String categoryDate = date(year, month, day);
                            Category category = new Category(categoryId, categoryName, categoryDate);
                            categoryList.add(category);
                            try (BufferedWriter bW = new BufferedWriter(new FileWriter(categoryPath))) {
                                for (Category category1 : categoryList) {
                                    bW.write(category1.getCategoryId() + " " + category1.getName() + " " + category1.getDate() + " ");
                                }
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            break;
                        case 2:
                            System.out.print("Güncellemek istediğiniz kategorinin id'sini giriniz : ");
                            int g = scan().nextInt()-1;
                            System.out.println("Hangisini güncellemek istersiniz?");
                            System.out.println("1-Ad");
                            System.out.println("2-Tarih");
                            System.out.println("3-Her ikisi");
                            System.out.print("Lütfen seçiniz : ");
                            int s = scan().nextInt();
                            if (s == 1) {
                                System.out.print("Adı giriniz : ");
                                String ad = scan().nextLine();
                                categoryList.get(g).setName(ad);
                            } else if (s == 2) {
                                System.out.print("Tarihi giriniz : ");
                                String tarih = scan().nextLine();
                                categoryList.get(g).setDate(tarih);
                            } else if (s == 3) {
                                System.out.print("Adı giriniz : ");
                                String ad = scan().nextLine();
                                System.out.print("Tarihi giriniz : ");
                                String tarih = scan().nextLine();
                                categoryList.get(g).setName(ad);
                                categoryList.get(g).setDate(tarih);
                            }else{
                                System.out.println("Lütfen doğru tuşladığınıza emin olunuz.");
                            }
                            break;
                        case 3:

                            break;
                        case 4:
                            for (Category cat : categoryList) {
                                System.out.println(cat.getCategoryId() + " " + cat.getName() + " " + cat.getDate());
                            }
                            break;
                        default:
                            break;

                    }

                    break;
                default:
                    break;

            }

        }
    }

    public static Scanner scan() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public static String date(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = simpleDateFormat.format(calendar.getTime());

        return str;
    }

}
