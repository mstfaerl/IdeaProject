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
public class InnerClassMain {

    public static void main(String[] args) {

        InnerClass dis = new InnerClass();
        InnerClass.InnerClass2 ic = new InnerClass.InnerClass2();

        InnerClass.disDegisken2 = 10;
        dis.disDegisken = 20;
        ic.icDegisken = 10;

        ic.Method();

        System.out.println("-------------------------");

        InnerClass2 dis1 = new InnerClass2();
        dis1.disDegisken = 10;
        InnerClass2.InnerClass3 ic1 = dis1.new InnerClass3(); //İçerdeki sınıfa erişebilmek için dıştaki sınıfın nesnesini oluşturup, DışSınıf.İçSınıf iç = dışnesne.new İçSınıf(); gibi oluşturulup kullanılmalıdır.
        ic1.icDegisken = 20;

        ic1.Method();

    }
}
