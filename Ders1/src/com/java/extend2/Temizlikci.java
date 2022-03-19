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
public class Temizlikci extends Person {

    @Override
    public String Cinsiyet() {
        return super.Cinsiyet(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FullName() {
        super.FullName(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Polymorphism Temizlikçi");
    }

}
