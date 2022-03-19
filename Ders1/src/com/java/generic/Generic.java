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
public class Generic<T> {

    private T a;

//    public Generic() {
//    }

    public Generic(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public void dataTypes() {
        System.out.println(a.getClass().getName());
    }
}
