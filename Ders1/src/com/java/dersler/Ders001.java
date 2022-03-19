/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dersler;

/**
 *
 * @author m07er
 */
public class Ders001 {

    public static void main(String[] args) {

//        System.out.println("Merhaba Dünya!");
//        System.err.println("Merhaba Dünya!");
//        System.exit(0);
//        System.gc();
//        System.out.println("Merhaba Dünya1!");
//
//        System.out.println("Dikdörtgen Çevresi : " + (4 + 4 + 2 + 2));
        
        byte b1 = 1;
        short s1 = 11;
        int x = 5;
        long l = (long) 6; // ya da  float long l = 6L; şeklinde cast işlemi yapılabilir.
        double d = 12.5;
        float f = (float)12.5; // ya da  float f = 12.5f; şeklinde cast işlemi yapılabilir.
        boolean b = true;
        char c = 'A'; // tek karakter girilebilir.
        
        int prsayi = 5;
        Integer refsayi = new Integer(prsayi); //Boxing
        prsayi = refsayi.intValue(); //Unboxing
        
        System.out.println("Boxing : " + refsayi);
        System.out.println("Unboxing : " + prsayi);
        String str = "12";
        Integer.valueOf(str);
        System.out.println(str);
        int a = 11;
        String ba = Integer.toString(a); 
        System.out.println(ba);
        
        System.out.println(Math.abs(-4.7));
        
    }

}
