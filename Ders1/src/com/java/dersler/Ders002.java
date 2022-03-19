package com.java.dersler;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m07er
 */
public class Ders002 {

    public static void main(String[] args) {

        /*
        byte b1 = 67, b2;
        long L1 = 123123, L2;

        L2 = b1;
        System.out.println("L2 değişkeni : " + L2);

        b1 = (byte) L1;

        System.out.println("b1 değişkeni : " + b1);
        
        String str1 = "44";
        int i1 = Integer.valueOf(str1);
        
        System.out.println("i1 değişkeni : " + i1);
        
        int a = (int) b1;
        
        System.out.println("a değişkeni : " + (a+i1));
        
        int a2 = 444_555;
        System.out.println("a2: " + a2);
        
        int ab=1,bc=2,max;
        max=(ab>bc)?ab:bc;
        System.out.println(max);
        
        
        
        
        //giriş
        Scanner input = new Scanner(System.in);
        
        System.out.print("Lütfen kullanici adınızı giriniz : ");
        String kAd = input.nextLine();
        System.out.print("Lütfen kullanici emailinizi giriniz : ");
        String Kemail = input.nextLine();
        System.out.print("Lütfen kullanici şifrenizi giriniz : ");
        String kSifre = input.nextLine();
        
        if(kAd.equalsIgnoreCase("Malatya") && kSifre.equalsIgnoreCase("Malatya123")){
            System.out.println("Merhabalar " + kAd + " Kullanıcısı Hoşgeldiniz.");
        }else{
            System.out.println("Yanlış gelmiş olabilir misiniz?");
        }
        
         
        //Haftanin günleri
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("0.Pazartesi");
            System.out.println("1.Salı");
            System.out.println("2.Çarşamba");
            System.out.println("3.Perşembe");
            System.out.println("4.Cuma");
            System.out.println("5.Cumartesi");
            System.out.println("6.Pazar");
            System.out.print("Lütfen gün seçiniz : ");
            int sayi = input.nextInt();

            switch (sayi) {
                case 0:
                    System.out.println("Pazartesi");
                    break;
                case 1:
                    System.out.println("Salı");
                    break;
                case 2:
                    System.out.println("Çarşamba");
                    break;
                case 3:
                    System.out.println("Perşembe");
                    break;
                case 4:
                    System.out.println("Cuma");
                    break;
                case 5:
                    System.out.println("Cumartesi");
                    break;
                case 6:
                    System.out.println("Pazar");
                    break;
                default:
                    System.out.println("Böyle bir seçenek yok!");
            }
            System.out.println("");
        }
         
        //iki sayı method
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen 1.sayıyı giriniz : ");
        int sayi1 = input.nextInt();
        System.out.print("Lütfen 2.sayıyı giriniz : ");
        int sayi2 = input.nextInt();
        
        sayiTopla(sayi1,sayi2);
        System.out.println("Return ile : "+ sayiToplaR(sayi1,sayi2));
         
       //Arraylar
       
        int[][] arr = {{23, 23, 1, 23}, {12, 23, 12, 34}, {34, 12, 34, 32}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
         
        int[] arr = new int[4];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        System.out.println(arr[0] + arr[1] + arr[2] + arr[3]);

        
        int[][] matrix = new int[3][2];
        matrix[0][0] = 5;
        matrix[0][1] = 15;
        matrix[1][0] = 25;
        matrix[1][1] = 35;
        matrix[2][0] = 45;
        matrix[2][1] = 55;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
         
        //Object dizi
        Object[] objeArr = new Object[4];
        objeArr[0] = "Musto";
        objeArr[1] = 15.6;
        objeArr[2] = 12;
        
        for (Object o : objeArr) {
            System.out.println("nesne : " + o);
        }
        
        
        
        int [] arr = {5,6,8,1,2};
        
        Arrays.sort(arr);
        
        for(int i : arr){
            System.out.print(" " + i);
        
        }
        System.out.println("");
        System.out.println("-----------------");
        
        int ara = Arrays.binarySearch(arr, 3);
        
        if(ara > 0 ){
            System.out.println("Aranılan değer dizide vardır");
        }else
            System.out.println("Aranılan değer dizide yoktur");
       
        
        Arrays.equals()// karşılaştırma yapar eşit midir değil midir?
        
        */
        Scanner scan = new Scanner(System.in);
        System.out.print("Lütfen boyut giriniz : ");
        int boyut = scan.nextInt();
        int arr[] = new int[boyut];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10 + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        int toplam = arr[0]+arr[arr.length-1];
        
        System.out.println("");
        hesapla(arr,2);
        
        hesapla(toplam);


    }
    public static void hesapla(int toplam){
        if(toplam > 10){
            System.out.println("10 dan büyük");
        }else
            System.out.println("10 dan küçük");
    }
    
    public static void hesapla(int [] arr , int indis){
        if(arr[indis] > 10 ){
            System.out.println("10 dan büyük");
        }else
            System.out.println("10 dan küçük");
    }
    /*
    public static void sayiTopla(int a, int b) {
        int sonuc;
        sonuc = a + b;
        System.out.println("Void ile : " +sonuc);
    }

    public static int sayiToplaR(int a, int b) {
        return a + b;
    }
     */
}
