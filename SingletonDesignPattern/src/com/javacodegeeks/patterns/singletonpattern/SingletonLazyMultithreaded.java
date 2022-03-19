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
public class SingletonLazyMultithreaded {

    private static SingletonLazyMultithreaded sc = null;

    private SingletonLazyMultithreaded() {
    }

    public static synchronized SingletonLazyMultithreaded getInstance() {
        if (sc == null) {
            sc = new SingletonLazyMultithreaded();
        }
        return sc;
    }

}
