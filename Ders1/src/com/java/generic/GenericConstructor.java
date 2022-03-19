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
public class GenericConstructor {

    private Object object;

    public <T> GenericConstructor(T object) {
        this.object = object;
    }

    public void methodName() {
        System.out.println("Data Types : " + object.getClass().getName());
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
