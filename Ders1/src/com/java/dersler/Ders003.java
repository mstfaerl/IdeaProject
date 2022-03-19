package com.java.dersler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m07er
 */
public class Ders003 {

    public static void main(String[] args) {

        //Ders003_1 ogr = new Ders003_1();
        Ders003_2 okul = new Ders003_2();
        okul.setOkulAdi("İlyas Sami");
        okul.setYapimYili("2003");
        okul.getStudent().setAd("Muhammed Mustafa");
        okul.getStudent().setSoyad("Erol");
        okul.getStudent().setOkulNo(937);

        System.out.println("Ögrencinin," + "\nOkuduğu Okul : " + okul.getOkulAdi() + "\nOkulun Yapım Yılı : " +okul.getYapimYili()+ "\nAdı : " + okul.getStudent().getAd() + "\nSoyadı : " + okul.getStudent().getSoyad() + "\nNumarası : " + okul.getStudent().getOkulNo() + "\n");

//        ogr.setAd("Muhammed Mustafa");
//        ogr.setSoyad("Erol");
//        ogr.setOkulNo(937);
//
//        System.out.println("Ögrencinin," + "\nAdı : " + ogr.getAd() + "\nSoyadı : " + ogr.getSoyad() + "\nNumarası : " + ogr.getOkulNo() + "\n");
//
//        Ders003_1 ogr1 = new Ders003_1("Emrullah", "Şahin", 356);
//        System.out.println("Ögrencinin," + "\nAdı : " + ogr1.getAd() + "\nSoyadı : " + ogr1.getSoyad() + "\nNumarası : " + ogr1.getOkulNo());
    }
}
