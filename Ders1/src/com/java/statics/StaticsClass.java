/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.statics;

/**
 *
 * @author m07er
 */
public class StaticsClass {

    //Fields
    private static String name; //Sınıf değişkeni
    private String surName; //Nesne değişkeni
    public static String age;

    //Getter and Setter
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StaticsClass.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

}
