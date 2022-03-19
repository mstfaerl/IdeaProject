/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.strings;

import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class StringMain {

    public static void main(String[] args) {

        String str = "Java Malatya Kursu";

        //Boyutunu getirir.
        System.out.println(str + " nin boyutu : " + str.length());

        //Boşlukları kapatır.
        System.out.println("Boşluklardan arındırılmış hali : " + str.trim());

        //Hepsini küçük yapar.
        System.out.println("Hepsi küçük : " + str.toLowerCase());

        //Hepsini büyük yapar.
        System.out.println("Hepsi büyük : " + str.toUpperCase());

        //Aralıkta olan değeri getirir.
        System.out.println("Parçalama : " + str.substring(0, 7));

        String str1 = "Full Stack";

        //İki ayrı string ifadeyi birleştirir.
        System.out.println("Birleştirme : " + str.concat(str1));

        //İstediğimiz indeksteki değeri getirir.
        System.out.println("charAt : " + str.charAt(2));

        //İfadenin içinde arar ilk bulduğunun başlangıç indeksini getirir.
        System.out.println("indexOf : " + str.indexOf("Malatya"));

        //indexOf un aynı işlevini sondan yapar.
        System.out.println("lastIndexOf : " + str.lastIndexOf("Kursu"));

        String str2 = "";

        //Boş mu dolu mu kontrolü yapar.
        if (!str2.isEmpty()) {
            System.out.println("Dolu : " + str);
        } else {
            System.out.println("Boşsun deli");
        }

        //İlk parametre eski değer 2.parametre yeni değer yerine yazar. 
        System.out.println("Replace : " + str.replace("Kursu", "575 saat KURS"));

        //İfade içeriğinde yazılan değer varsa true yoksa false
        System.out.println("Contains : " + str.contains("Malatya"));

        //Split dizi şeklinde cümledeki tüm kelimeleri tutar.
        String[] arr = str.split(" ");
        for (String str3 : arr) {
            System.out.println(str3);
        }

        //Eğer yazılan kelime ile başlıyorsa true diğer şekilde false
        System.out.println("StartsWith : " + str.startsWith("Java"));

        //Eğer yazılan kelime ile bitiyorsa true diğer şekilde false
        System.out.println("endsWith  :" + str.endsWith("Kursu"));

        String str5 = "MUSTAFA EROL";
        String str6 = "Mustafa Erol";

        if (str5.equals(str6)) {
            System.out.println("Equals Doğru");
        } else {
            System.out.println("Equals Yanlış");
        }

        if (str5.equalsIgnoreCase(str6)) {
            System.out.println("EqualsIgnoreCase Doğru");
        } else {
            System.out.println("EqualsIgnoreCase Yanlış");
        }

        int sayi = 3,sayi1 = 3,sayi2 = 4;

        if(sayi == sayi1){
            System.out.println("Eşittir.");
        }else
            System.out.println("Eşit Değildir.");
        
        if(sayi == sayi2){
            System.out.println("Eşittir.");
        }else
            System.out.println("Eşit Değildir.");
        
    }

}
