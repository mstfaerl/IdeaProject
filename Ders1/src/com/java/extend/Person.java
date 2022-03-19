/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.extend;

/**
 *
 * @author m07er
 */
public class Person {

    //Genel ortak özellikler
    //nesne değişkenleri fields
    private long personId;
    private String personTc;
    private String personIsim;
    private String personSoyisim;
    private int personYas;
    private String personAdres;
    private boolean personCinsiyet;

    //parametresiz constructor
    public Person() {

    }

    //parametreli constructor
    public Person(long personId, String personTc, String personIsim, String personSoyisim, int personYas, String personAdres, boolean personCinsiyet) {
        this.personId = personId;
        this.personTc = personTc;
        this.personIsim = personIsim;
        this.personSoyisim = personSoyisim;
        this.personYas = personYas;
        this.personAdres = personAdres;
        this.personCinsiyet = personCinsiyet;
    }

    //Getter and Setter
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonTc() {
        return personTc;
    }

    public void setPersonTc(String personTc) {
        this.personTc = personTc;
    }

    public String getPersonIsim() {
        return personIsim;
    }

    public void setPersonIsim(String personIsim) {
        this.personIsim = personIsim;
    }

    public String getPersonSoyisim() {
        return personSoyisim;
    }

    public void setPersonSoyisim(String personSoyisim) {
        this.personSoyisim = personSoyisim;
    }

    public int getPersonYas() {
        return personYas;
    }

    public void setPersonYas(int personYas) {
        this.personYas = personYas;
    }

    public String getPersonAdres() {
        return personAdres;
    }

    public void setPersonAdres(String personAdres) {
        this.personAdres = personAdres;
    }

    public boolean isPersonCinsiyet() {
        return personCinsiyet;
    }

    public void setPersonCinsiyet(boolean personCinsiyet) {
        this.personCinsiyet = personCinsiyet;
    }

    //Methods
    public void FullName() {
        System.out.println("Adı : " + this.personIsim + " Soyadı : " + this.personSoyisim);
    }

    public String Cinsiyet() {
        String cinsiyet = null;
        if (this.personCinsiyet == false) {
            cinsiyet = "Erkek";
        } else {
            cinsiyet = "Kadın";
        }
        return cinsiyet;
    }

}
