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
public class GenericMethod {

    public <T> void genericMethod(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
        
    }

}
