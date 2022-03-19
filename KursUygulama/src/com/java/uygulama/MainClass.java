/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama;

import com.java.entity.Kullanici;
import com.java.files.KullaniciFiles;
import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class MainClass {

    public static void main(String[] args) {

        while (true) {
            secimKontrol();
        }
    }

    public static void secimKontrol() {

        Scanner scan = new Scanner(System.in);
        System.out.println("İşlem Merkezine Hoşgeldiniz.\n");
        System.out.println("1-Kullanıcı İşlemleri");
        System.out.println("2-Ürün İşlemleri");
        System.out.println("3-Domain İşlemleri");
        System.out.println("4-Host İşlemleri");
        System.out.println("5-Kategori İşlemleri");
        System.out.println("6-Sosyal Medya İşlemleri");
        System.out.println("7-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:
                kullaniciKontrol();
                break;
            case 2:
                urunKontrol();
                break;
            case 3:
                domainKontrol();
                break;
            case 4:
                hostKontrol();
                break;
            case 5:
                kategoriKontrol();
                break;
            case 6:
                sosyalKontrol();
                break;
            case 7:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
                break;
            default:
                break;
        }

    }

    public static void kullaniciKontrol() {

        Kullanici kullanici;
        KullaniciFiles kullaniciFiles = new KullaniciFiles();
        
        System.out.println("Kullanıcı İşlemlerine Hoşgeldiniz.\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Ekleme");
        System.out.println("2-Güncelleme");
        System.out.println("3-Silme");
        System.out.println("4-Listeleme");
        System.out.println("5-Bir Önceki Menü");
        System.out.println("6-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:
                System.out.print("Lütfen kullanıcı idnizi giriniz : ");
                long kId = scan.nextInt();
                System.out.print("Lütfen adınızı giriniz : ");
                String kAdi = scan.next();
                System.out.print("Lütfen kullanıcı şifrenizi giriniz : ");
                int kSifre = scan.nextInt();
                kullanici = new Kullanici(kId, kAdi, kSifre);
                kullaniciFiles.addFile(kullanici);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                secimKontrol();
                break;
            case 6:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
            case 7:
                break;
            default:
                break;
        }

    }

    public static void urunKontrol() {

        System.out.println("Ürün İşlemlerine Hoşgeldiniz.\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Ekleme");
        System.out.println("2-Güncelleme");
        System.out.println("3-Silme");
        System.out.println("4-Listeleme");
        System.out.println("5-Bir Önceki Menü");
        System.out.println("6-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                secimKontrol();
                break;
            case 6:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
            case 7:
                break;
            default:
                break;
        }

    }

    public static void domainKontrol() {

        System.out.println("Domain İşlemlerine Hoşgeldiniz.\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Ekleme");
        System.out.println("2-Güncelleme");
        System.out.println("3-Silme");
        System.out.println("4-Listeleme");
        System.out.println("5-Bir Önceki Menü");
        System.out.println("6-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                secimKontrol();
                break;
            case 6:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
            case 7:
                break;
            default:
                break;
        }

    }

    public static void hostKontrol() {

        System.out.println("Host İşlemlerine Hoşgeldiniz.\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Ekleme");
        System.out.println("2-Güncelleme");
        System.out.println("3-Silme");
        System.out.println("4-Listeleme");
        System.out.println("5-Bir Önceki Menü");
        System.out.println("6-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                secimKontrol();
                break;
            case 6:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
            case 7:
                break;
            default:
                break;
        }

    }

    public static void kategoriKontrol() {

        System.out.println("Kategori İşlemlerine Hoşgeldiniz.\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Ekleme");
        System.out.println("2-Güncelleme");
        System.out.println("3-Silme");
        System.out.println("4-Listeleme");
        System.out.println("5-Bir Önceki Menü");
        System.out.println("6-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                secimKontrol();
                break;
            case 6:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
            case 7:
                break;
            default:
                break;
        }
    }

    public static void sosyalKontrol() {

        System.out.println("Sosyal Medya İşlemlerine Hoşgeldiniz.\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Ekleme");
        System.out.println("2-Güncelleme");
        System.out.println("3-Silme");
        System.out.println("4-Listeleme");
        System.out.println("5-Bir Önceki Menü");
        System.out.println("6-Çıkış");
        System.out.print("Lütfen giriş yapmak istediğiniz sekmeyi seçiniz : ");
        int secim = scan.nextInt();
        System.out.println("");

        switch (secim) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                secimKontrol();
                break;
            case 6:
                System.out.println("Sistemden çıkılıyor.\n");
                System.exit(0);
            case 7:
                break;
            default:
                break;
        }

    }

}
