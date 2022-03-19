/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.geneltekrar;

import java.util.Scanner;

/**
 *
 * @author m07er
 */
public class GenelTekrar {

    public static void main(String[] args) {

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.Para yatırmak için tıklayınız.");
            System.out.println("2.Hesabınızın özeti için tıklayınız.");
            System.out.println("3.Para çekmek için tıklayınız.");
            System.out.println("4.Eft yapmak için tıklayınız.");
            System.out.println("5.Havale yapmak için tıklayınız.");
            System.out.println("6.Çıkış.");

            System.out.print("Lütfen seçmek istediğiniz kategoriyi giriniz : ");
            int input = scan.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Lütfen yatırılacak para miktarını giriniz : ");
                    int paraMiktari = scan.nextInt();
                    System.out.println("");
                    paraYatir(paraMiktari);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    hesapOzeti();
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Lütfen çekilecek para miktarını giriniz : ");
                    int cParaMiktari = scan.nextInt();
                    System.out.println("");
                    paraCekme(cParaMiktari);
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Eft gönderen bankayı giriniz : ");
                    String gBankaAdi = scan.next();
                    System.out.print("Eft alıcı bankayı giriniz : ");
                    String aBankaAdi = scan.next();
                    System.out.print("Göndereceğiniz miktari giriniz : ");
                    int gonMiktar = scan.nextInt();
                    System.out.println("");
                    eftIslemi(gBankaAdi, aBankaAdi, gonMiktar);
                    System.out.println("");
                    break;
                case 5:
                    System.out.print("Havale gönderen bankayı giriniz : ");
                    String goBankaAdi = scan.next();
                    System.out.print("Havale alıcı bankayı giriniz : ");
                    String alBankaAdi = scan.next();
                    System.out.print("Göndereceğiniz miktari giriniz : ");
                    int gMiktar = scan.nextInt();
                    System.out.println("");
                    havaleIslemi(goBankaAdi, alBankaAdi, gMiktar);
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("");
                    System.out.println("Çıkış işleminiz başarıyla gerçekleşmiştir.");
                    exit();  
                    break;
                default:
                    System.out.println("Hatalı tuşladınız, lütfen daha sonra tekrar deneyiniz.");
                    break;
            }
        }

    }

    public static void paraYatir(int paraMiktar) {
        if (paraMiktar > 0 && paraMiktar <= 5000) {
            System.out.println("Yatırılan para miktarı : " + paraMiktar);
        } else {
            System.out.println("Günlük para yatırma limitini aştınız.");
        }
    }

    public static void hesapOzeti() {
        System.out.println("Hesap özetiniz bulunmamaktadır.");
    }

    public static void paraCekme(int paraMiktari) {
        if (paraMiktari > 0 && paraMiktari <= 1000) {
            System.out.println("Çekilecek para miktari : " + paraMiktari);
        } else {
            System.out.println("Günlük para çekme miktarını aştınız.");
        }
    }

    public static void eftIslemi(String gBanka, String aBanka, int gMiktar) {
        if (gBanka.equalsIgnoreCase(aBanka)) {
            System.out.println("Aynı iki banka arasında eft işlemi yapılamaz.");
        } else {
            System.out.println(gBanka + " bankasından " + aBanka + " bankasına " + gMiktar + " TL eft işlemi gerçekleştirdiniz.");
        }
    }

    public static void havaleIslemi(String gBanka, String aBanka, int gMiktar) {
        if (!gBanka.equalsIgnoreCase(aBanka)) {
            System.out.println("Farkli iki banka arasında havale işlemi yapılamaz.");
        } else {
            System.out.println(gBanka + " bankasından " + aBanka + " bankasına " + gMiktar + " TL havale işlemi gerçekleştirdiniz.");
        }
    }

    public static void exit() {
        System.exit(0);
    }

}
