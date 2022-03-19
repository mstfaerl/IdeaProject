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
public class StaticsTutorials {

    //Static oluşturulan nesne ve methodlar için nesne oluşturmadığımız için hafızada alan kaplamaz.
    public static void method() {
        System.out.println("voidli staticli metodum ben");
    }

    public static void main(String[] args) {
        StaticsClass class1 = new StaticsClass();
        class1.setSurName("asd");
        StaticsClass.setName("dfg");
        StaticsClass.age = "23";
        System.out.println(StaticsClass.getName()/*Class değişkeni private*/ + " " + class1.getSurName()/*Nesne değişkeni*/ + " " + StaticsClass.age /*Class değişkeni public*/);
        method();
        double a = Math.PI;
        System.out.println(a);
    }
}
