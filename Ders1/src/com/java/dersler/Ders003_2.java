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
public class Ders003_2 {
    
    private String okulAdi;
    private String yapimYili;
    private Ders003_1 student;

    public Ders003_2() {
    }

    public Ders003_2(String okulAdi, String yapimYili, Ders003_1 student) {
        this.okulAdi = okulAdi;
        this.yapimYili = yapimYili;
        this.student = student;
    }
   

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public String getYapimYili() {
        return yapimYili;
    }

    public void setYapimYili(String yapimYili) {
        this.yapimYili = yapimYili;
    }

    public Ders003_1 getStudent() {
        if(this.student == null){
            this.student = new Ders003_1();
        }
        return student;
    }

    public void setStudent(Ders003_1 student) {
        this.student = student;
    }    
    
}
