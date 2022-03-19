/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.calisma;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class Calisma {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Lütfen bir sayi giriniz : ");
        int girdi = scan.nextInt();

        System.out.println(girdi + " nin faktöriyeli : " + factorial(girdi));

        System.out.println("Faktöriyelinin karekökü : " + karekok(factorial(girdi)));

        System.out.println("Karekök ün karesi : " + karesi(karekok(factorial(girdi))));

        double a = karesi(karekok(factorial(girdi)));

        double dizi[] = new double[4];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = (Math.random() * 30 + 1);
        }

        siralama(a, dizi[0], dizi[1], dizi[2], dizi[3]);

    }

    public static int factorial(int a) {
        int hesap = 1;
        if (a > 0) {
            for (int i = 1; i <= a; i++) {
                hesap *= i;
            }
        }
        if (a == 0) {
            hesap = 1;
        }
        return hesap;
    }

    public static double karekok(int deger) {
        double hesap = Math.sqrt(deger);
        return hesap;
    }

    public static double karesi(double deger) {
        double hesap = Math.pow(deger, 2);
        return hesap;
    }

    public static void siralama(double girdi1, double girdi2, double girdi3, double girdi4, double girdi5) {
        
        double dizi[] = new double[5];
        dizi[0] = girdi1;
        dizi[1] = girdi2;
        dizi[2] = girdi3;
        dizi[3] = girdi4;
        dizi[4] = girdi5;

        for (int i = 0; i < dizi.length; i++) {
            System.out.println("dizi : " + dizi[i]);
        }

        Arrays.sort(dizi);
        System.out.println("Yeni Sıralanmış dizi");

        for (int i = 0; i < dizi.length; i++) {
            System.out.println("dizi : " + dizi[i]);
        }
        
        System.out.println("En küçük eleman : " + dizi[0]);
    }

}
