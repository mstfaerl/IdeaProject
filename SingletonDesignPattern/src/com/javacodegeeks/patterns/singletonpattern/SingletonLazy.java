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
public class SingletonLazy {

    private static SingletonLazy sc = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (sc == null) {
            sc = new SingletonLazy();
        }
        return sc;
    }

}
