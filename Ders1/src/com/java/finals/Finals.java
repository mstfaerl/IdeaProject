/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.finals;

/**
 *
 * @author m07er
 */
abstract public class Finals {

    final int sayi = 8;
    private static String finalDate;
    private String finalName;
    private String finalSurname;

    //Parametresiz constructor
    public Finals() {

    }

    //Parametreli constructor
    public Finals(String finalName, String finalSurname) {
        this.finalName = finalName;
        this.finalSurname = finalSurname;
    }

    public static String getFinalDate() {
        return finalDate;
    }

    public static void setFinalDate(String finalDate) {
        Finals.finalDate = finalDate;
    }

    public String getFinalName() {
        return finalName;
    }

    public void setFinalName(String finalName) {
        this.finalName = finalName;
    }

    public String getFinalSurname() {
        return finalSurname;
    }

    public void setFinalSurname(String finalSurname) {
        this.finalSurname = finalSurname;
    }

    public String method() {
        return "String yapıyım.";
    }

    //Method final olduğundan override edilemez.
    public final String method1() {
        return "final String yapıyım.";
    }
    

//    public static String method2() {
//        return "static String yapıyım.";
//    }
}
