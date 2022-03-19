/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.calismalar;

import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class Uygulama {

    public static void main(String[] args) {

        System.out.print("Dizi boyutunu giriniz : ");
        int boyut = Scan().nextInt();
        String[] arr = new String[boyut];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Lütfen dizinin " + i + ". elamanı giriniz : ");
            arr[i] = Scan().nextLine();
        }

        //Dizi tersleme
        String[] arrKarisik = new String[arr.length];
        int diziBoyut = arrKarisik.length - 1;
        for (int i = 0; i < arrKarisik.length; i++) {
            arrKarisik[diziBoyut] = arr[i];
            diziBoyut--;
        }
        
        for (String string : arrKarisik) {
            System.out.println("Karışık dizi : " + string);
        }
        
        int deger = Integer.parseInt(arr[2]);
        Method(deger);

    }

    public static Scanner Scan() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }
    
    public static void Method(int value){
        if(value > 2000){
            System.out.println("Değer 2000'den büyüktür.");
        }else
            System.out.println("Değer 2000'den küçüktür.");
    }
}
