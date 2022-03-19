/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.maths;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class Maths {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("İlk sayiyi giriniz : ");
            double ilkSayi = scan.nextDouble();
            System.out.print("İkinci sayiyi giriniz : ");
            double ikinciSayi = scan.nextDouble();

            System.out.println("Sonuc : " + Math.ceil(carpma(ilkSayi, ikinciSayi)));

        } catch (InputMismatchException ie) {
            System.out.println("Noktalama Hatası " + ie.getMessage());
        }
    }

    public static double carpma(double val1, double val2) {
        double result = val1 * val2;
        return result;
    }

}
