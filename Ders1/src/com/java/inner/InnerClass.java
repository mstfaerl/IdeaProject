/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.inner;

/**
 *
 * @author m07er
 */
public class InnerClass {

    int disDegisken;
    static int disDegisken2;

    public static class InnerClass2 {

        int icDegisken;

        public void Method() {
            //System.out.println(disDegisken); //Sınıf static olduğundan sadece static olan değişkenler erişebilir.
            System.out.println("Dış değişken 2 : " + disDegisken2);
            System.out.println("İç değişken : " + icDegisken);
        }

    }

}
