/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.entity;

/**
 *
 * @author m07er
 */
public class Kullanici {

    private long kullaniciID;
    private String kullaniciAdi;
    private int kullaniciSifre;

    public Kullanici() {
    }

    public Kullanici(long kullaniciID, String kullaniciAdi, int kullaniciSifre) {
        this.kullaniciID = kullaniciID;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSifre = kullaniciSifre;
    }

    public long getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(long kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public int getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(int kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

}
