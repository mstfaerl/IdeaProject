/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author m07er
 */
public class CategoryMain {

    public static void main(String[] args) {

        String cId = new StringBuilder().append("1").toString();
        String cPrice = new StringBuilder().append("350").toString();
        String cId2 = new StringBuilder().append("2").toString();
        String cPrice2 = new StringBuilder().append("550").toString();
        String cAd1 = new StringBuilder().append("Bilgisayar").toString();
        String cAd2 = new StringBuilder().append("Televizyon").toString();

        long cId1 = Long.parseLong(cId);
        double cPrice1 = Double.parseDouble(cPrice);
        long cId3 = Long.parseLong(cId2);
        double cPrice3 = Double.parseDouble(cPrice2);

        Categories category = new Categories(cId1, cAd1, cPrice1);
        Categories category1 = new Categories(cId3, cAd2, cPrice3);

        Scanner scan = new Scanner(System.in);
        System.out.print("Lütfen path giriniz : ");
        String path = new StringBuilder().append(scan.nextLine()).toString(); //"D:\\Data\\data3.txt"

        String slash = "\\" + "\\";

        String[] arr = path.split(" ");

        String path1 = "";
        String path2 = "";
        for (int i = 0; i < arr.length - 1; i++) {
            path1 += arr[i].concat(slash);
            path2 = arr[arr.length - 1];
        }

        path = path1.concat(path2);

//        for (String str2 : arr) {
//            System.out.println(str2);
//        }
//        while(sTok.hasMoreTokens()){
//            arr[i] = sTok.nextToken(); 
//            i++;
//        }
//        String path1 = arr[0].concat(slash) + arr[1].concat(slash) + arr[2];
//        System.out.println("Str : " + path1);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Id : " + category.getCategoryID() + " - Ad : " + category.getCategoryName() + " - Fiyat : " + category.getCategoryPrice() + "\n");
            bw.write("Id : " + category1.getCategoryID() + " - Ad : " + category1.getCategoryName() + " - Fiyat : " + category1.getCategoryPrice());
        } catch (Exception e) {
            System.out.println(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

        } catch (Exception e) {

        }

    }

}
