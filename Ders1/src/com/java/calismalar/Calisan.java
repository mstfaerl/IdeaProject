/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.calismalar;

/**
 *
 * @author m07er
 */
public class Calisan {

    private String ad;
    private String soyad;
    private int maas;

    public Calisan() {
    }

    public Calisan(String ad, String soyad, int maas) {
        this.ad = ad;
        this.soyad = soyad;
        this.maas = maas;
    }

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

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        if (maas < 0) {
            System.out.println("Maaş sıfırdan büyük olmalıdır!");
        } else {
            this.maas = maas;
        }
    }

}
