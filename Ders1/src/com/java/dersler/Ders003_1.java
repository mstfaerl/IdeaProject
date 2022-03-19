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
public class Ders003_1 {

    //field nesne değişkenleri ---> static olmadığı sürece nesne değişkenleridir
    private String ad;
    private String soyad;
    private int okulNo;

    public Ders003_1() {

    }

    public Ders003_1(String ad, String soyad, int okulNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.okulNo = okulNo;
    }

    //Getter and Setter
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getOkulNo() {
        return okulNo;
    }

    public void setOkulNo(int okulNo) {
        this.okulNo = okulNo;
    }

}
