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
public class Teknopark {
    
    private String ad;
    private int yapimYili;
    private Calisan calisan;

    public Teknopark() {
    }

    public Teknopark(String ad, int yapimYili, Calisan calisan) {
        this.ad = ad;
        this.yapimYili = yapimYili;
        this.calisan = calisan;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getYapimYili() {
        return yapimYili;
    }

    public void setYapimYili(int yapimYili) {
        this.yapimYili = yapimYili;
    }

    public Calisan getCalisan() {
        if(this.calisan == null){
            this.calisan = new Calisan();
        }
        return calisan;
    }

    public void setCalisan(Calisan calisan) {
        this.calisan = calisan;
    }
    
}
