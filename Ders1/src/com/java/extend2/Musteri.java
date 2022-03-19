/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.extend2;

import com.java.extend.Person;

/**
 *
 * @author m07er
 */
public class Musteri extends Person {
    
    private String musteriId;
    private String musteriPuan;

    public Musteri() {
    }

    public Musteri(String musteriId, String musteriPuan) {
        this.musteriId = musteriId;
        this.musteriPuan = musteriPuan;
    }

    public String getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(String musteriId) {
        this.musteriId = musteriId;
    }

    public String getMusteriPuan() {
        return musteriPuan;
    }

    public void setMusteriPuan(String musteriPuan) {
        this.musteriPuan = musteriPuan;
    }  

    @Override
    public void FullName() {
        super.FullName(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Ben müşteri Polymorphism");
    }
    
    @Override
    public String Cinsiyet() {
        return super.Cinsiyet(); //To change body of generated methods, choose Tools | Templates.
    }

}
