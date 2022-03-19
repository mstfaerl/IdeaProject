/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author m07er
 */

public class Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @interface FullName {

        String ad();

        String soyad();
    }

    @FullName(ad = "Mustafa", soyad = "EROL")
    class Ann {

    }

    public static void main(String[] args) {
        Class<Ann> class1 = Ann.class;
        Annotation annotations = class1.getAnnotation(FullName.class);
        FullName fN = (FullName) annotations;
        System.out.println("Annotation Ad : " + fN.ad() + "\nAnnotation Soyad : " + fN.soyad());
    }

}
