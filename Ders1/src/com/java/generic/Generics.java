/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.generic;

/**
 *
 * @author m07er
 */
public class Generics<T> {

    private String name;
    private String surname;
    private T fiyat; // fiyat bazen tam sayı bazen ondalıklı sayı olabilir.

    //Constructor without parameter
    public Generics() {
    
    }
    
    //Constructor with parameters
    public Generics(String name, String surname, T fiyat) {
        this.name = name;
        this.surname = surname;
        this.fiyat = fiyat;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public T getFiyat() {
        return fiyat;
    }

    public void setFiyat(T fiyat) {
        this.fiyat = fiyat;
    }

}
