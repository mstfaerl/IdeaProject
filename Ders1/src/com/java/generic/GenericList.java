/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.generic;

import java.util.ArrayList;

/**
 *
 * @author m07er
 */
public class GenericList<T> {

    private ArrayList<T> list;

    public GenericList() {

    }

    public GenericList(ArrayList<T> list) {
        this.list = list;
    }

    public ArrayList<T> getList() {
        if(this.list == null){
            this.list = new ArrayList<T>();
        }
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

}
