/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.strings;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class StringUygulama {

    public static void main(String[] args) {

//        String str = "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eligendi cupiditate maxime incidunt quod obcaecati non fugiat, modi distinctio eaque provident debitis architecto ipsa porro sequi perspiciatis quam officiis quaerat deleniti.Saepe porro fugiat, nobis id facilis quam! Culpa adipisci tempora mollitia nisi ea inventore nam voluptas, dolorem ducimus eius incidunt itaque quis deleniti quas minus aut quam! Nobis, perspiciatis nisi.";
//        System.out.println(str.length());
//
//        String str1 = str.substring(0, 100);
//        System.out.println(str1);
//
//        System.out.println(str1.concat("..."));
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
            
        String str = "Malatya Teknokent 2019 Java";

        String[] arr = str.split(" ");
        for (String string : arr) {
            System.out.print(string + " ");
        }

        System.out.println("");
        int toplam = 0;
        int degisken = 0;
        for (int i = 0; i < arr.length; i++) {
            toplam += (int) arr[i].charAt(0);
            degisken = (int) arr[i].charAt(0);
            System.out.println(arr[i].charAt(0) + " : " + degisken);
        }
        System.out.println("Toplam : " + toplam);

        Calendar cal = Calendar.getInstance();
        int yil = cal.get(Calendar.YEAR);
        System.out.println("Yıl : " + yil);

        int sifre = yil - toplam;

        System.out.println("Sifre : " + sifre);

        String sSifre = String.valueOf(sifre);
        String[] arr1 = sSifre.split("");

        for (String string1 : arr1) {
            System.out.println(string1);
        }

        for (int i = 0; i < arr1.length; i++) {
            String a = String.valueOf(arr1[i].charAt(0));
            int ab = Integer.parseInt(a);
            switch (ab) {
                case 1:
                    arr1[i] = "b";
                    break;
                case 2:
                    arr1[i] = "c";
                    break;
                case 3:
                    arr1[i] = "d";
                    break;
                case 4:
                    arr1[i] = "f";
                    break;
                case 5:
                    arr1[i] = "g";
                    break;
                case 6:
                    arr1[i] = "j";
                    break;
                case 7:
                    arr1[i] = "k";
                    break;
                case 8:
                    arr1[i] = "l";
                    break;
                case 9:
                    arr1[i] = "m";
                    break;
                default:
                    System.out.println("Olmaz");
                    break;

            }
        }
        
        String dizi[] = {"a","e","i","ı","o","ö","u","ü"};
        String dizi1[] = new String[arr1.length];
        for (int i = 0; i < dizi1.length; i++) {
            dizi1[i] = dizi[i];
        }
        int sayi = 0;
        String son = "";
        for (String string : arr1) {
            //System.out.print(string.concat(dizi[sayi]));
            son += string.concat(dizi1[sayi]);
            sayi++;
        }
        System.out.println("Son Hali : " + son);

    }

}
