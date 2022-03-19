/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.patterns.singletonpattern;

/**
 *
 * @author m07er
 */
public class SingletonLazyDoubleCheck {

    private volatile static SingletonLazyDoubleCheck sc = null;

    private SingletonLazyDoubleCheck() {
    }

    public static SingletonLazyDoubleCheck getInstance() {
        if (sc == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (sc == null) {
                    sc = new SingletonLazyDoubleCheck();
                }
            }
        }
        return sc;
    }

}
