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
public class MainClass {

    public static void main(String[] args) {

        Teknopark tPark = new Teknopark();

        tPark.setAd("Malatya Teknokent");
        tPark.setYapimYili(2011);
        tPark.getCalisan().setAd("Mustafa");
        tPark.getCalisan().setSoyad("Erol");
        tPark.getCalisan().setMaas(-500);

        System.out.println(tPark.getAd() + " " + tPark.getYapimYili() + " " + tPark.getCalisan().getAd() + " " + tPark.getCalisan().getSoyad() + " " + tPark.getCalisan().getMaas());

        int a = (int) 42E+2;//iki vurgul sağa yani iki sıfır ekler
        double b = 4222E-2;//iki vurgul sola yani 42.22 yapar
        
        System.out.println(a);
        System.out.println(b);
    }
}
