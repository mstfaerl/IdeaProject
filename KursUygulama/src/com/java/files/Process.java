/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.files;

import java.util.ArrayList;

/**
 *
 * @author m07er
 * @param <T>
 */
public interface Process <T>{
    
    void addFile(T o);
    void update(T o);
    void delete(T o);
    ArrayList<T> list();
    
    
}
