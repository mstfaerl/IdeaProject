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
public class SingletonEager {

    private static SingletonEager sc = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return sc;
    }

}
