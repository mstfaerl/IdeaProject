/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dersler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class Ders004 {

    public static void main(String[] args) {
//       
//        ArrayList<String> asd = new ArrayList<>(); 
//        asd.add("asd");
//        asd.add("qwr");
//        asd.add("fdg");
//        int a = asd.size();
//        int i = 0;
//        
//        System.out.println("Boyutu : " + a);
//        Collections.sort(asd);
//        System.out.println("Son eleman : " + asd.get(a-1));
//        
//        for (String string : asd) {          
//            System.out.println("Liste : " + i +". "+ string );
//            i++;
//        }
//        System.out.println();
//
//        List<String> list = new ArrayList<String>();
//        list.add("Malatya"); //add() Listeye ekleme yapar.
//        list.add("Kayseri");
//        list.add("Sivas");
//        list.add("Ankara");
//        list.add("İstanbul");
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(i + 1 + ". eleman : " + list.get(i)); //get() İstenilen indisteki değeri getirir.
//        }
//
//        System.out.println("---------------------------------");
//
//        list.remove("İstanbul");//remove() İstenilen değeri bulur ve siler.
//        int i = 1;
//        for (String str : list) {
//            System.out.println(i + ". eleman : " + str);
//            i++;
//        }
//        
//        System.out.println("---------------------------------");
//
//        list.set(2, "İstanbul");
//
//        int j = 1;
//        for (String str : list) {
//            System.out.println(j + ". eleman : " + str);
//            j++;
//        }
//
//        System.out.println("---------------------------------");
//        list.clear();//clear() Tamamen değişkenlerin hepsini siler.
//
//        int k = 1;
//        for (String str : list) {
//            System.out.println(k + ". eleman : " + str);
//            k++;
//        }
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<String>();

        while (true) {

            System.out.println("1.Listeye eleman eklemek için.");
            System.out.println("2.Listeden eleman getirmek için.");
            System.out.println("3.Listeden eleman silmek için.");
            System.out.println("4.Listenin boyutunu görmek için.");
            System.out.println("5.Listelemek için.");
            System.out.println("6.Listeyi silmek için.");
            System.out.println("");
            System.out.print("Lütfen girmek istediğiniz sekmeyi seçiniz : ");
            int giris = scan.nextInt();

            switch (giris) {
                case 1:
                    try {
                        System.out.print("Lütfen listeye ekleyeceğiniz şehir ismini giriniz : ");
                        String deger = scan.next();
                        list.add(deger);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case 2:
                    System.out.print("Lütfen listeden istediğiniz elamanın indisini giriniz : ");
                    int indis = scan.nextInt();
                    System.out.println("");
                    System.out.println("Listenin " + indis + ". elemanı : " + list.get(indis));
                    break;
                case 3:
                    System.out.print("Lütfen listeden silmek istediğiniz elamanın ismini giriniz : ");
                    String str1 = scan.next();
                    list.remove(str1);
                    System.out.println("");
                    System.out.println(str1 + " elamanı listeden silindi.");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Listenin boyutu : " + list.size());
                    break;
                case 5:
                    System.out.println("");
                    int i = 0;
                    for (String str : list) {
                        System.out.println(i + ". eleman : " + str);
                        i++;
                    }
                    System.out.println("Listelendi.");
                    break;
                case 6:
                    list.clear();
                    break;
                default:
                    System.out.println("Böyle bir seçenek bulunamadı.");
                    break;
            }
            System.out.println("--------------------------------");
        }

    }

}
